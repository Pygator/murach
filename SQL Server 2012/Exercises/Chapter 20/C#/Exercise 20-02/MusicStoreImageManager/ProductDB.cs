using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Data.SqlTypes;
using System.IO;
using System.Windows.Forms;

namespace MusicStoreImageManager
{
    class ProductDB
    {
        // define the directory for the images
        static string imagesPath = "C:/Murach/SQL Server 2012/Images/";

        public static SqlConnection GetConnection()
        {
            SqlConnection connection = new SqlConnection();
            connection.ConnectionString = 
                "Data Source=localhost\\SqlExpress;" + 
                "Initial Catalog=MusicStore;Integrated Security=True";
            return connection;
        }

        public static void WriteImage(int productID, string imageName)
        {
            SqlConnection connection = null;
            SqlTransaction transaction = null;
            try
            {
                // 1. Set up the input stream from the image file
                string filepath = imagesPath + imageName;
                if (File.Exists(filepath) == false)
                    throw new Exception("File Not Found: " + filepath);

                FileStream sourceStream = new FileStream(
                    filepath,
                    FileMode.Open,
                    FileAccess.Read);

                // 2. Initialize the row in the table
                connection = GetConnection();

                SqlCommand command = new SqlCommand();
                command.Connection = connection;
                command.CommandText =
                    "INSERT INTO ProductImages " +
                    "VALUES (@ProductID, " +
                    "        CAST(@RowID AS uniqueidentifier), 0)";

                Guid rowID = Guid.NewGuid();
                command.Parameters.AddWithValue("@ProductID", productID);
                command.Parameters.AddWithValue("@RowID", rowID);

                connection.Open();
                command.ExecuteNonQuery();

                // 3. Get a reference to the BLOB
                transaction = connection.BeginTransaction();
                command.Transaction = transaction;
                command.CommandText =
                    "SELECT ProductImage.PathName(), " +
                    "       GET_FILESTREAM_TRANSACTION_CONTEXT() " +
                    "FROM ProductImages " +
                    "WHERE RowID = CAST(@RowID AS uniqueidentifier)";
                command.Parameters.Clear();
                command.Parameters.AddWithValue("@RowID", rowID);

                SqlDataReader reader = command.ExecuteReader();
                if (reader.Read() == false)
                {
                    throw new Exception("Unable to get path and context for BLOB.");
                }
                string path = (string)reader[0];
                byte[] context = (byte[])reader[1];
                reader.Close();

                // 4. Set up the output stream to the database
                SqlFileStream targetStream = 
                    new SqlFileStream(path, context, FileAccess.Write);

                // 5. Read from file and write to database
                int blockSize = 1024 * 512;
                byte[] buffer = new byte[blockSize];
                int bytesRead = sourceStream.Read(buffer, 0, buffer.Length);
                while (bytesRead > 0)
                {
                    targetStream.Write(buffer, 0, bytesRead);
                    bytesRead = sourceStream.Read(buffer, 0, buffer.Length);
                }

                targetStream.Close();
                sourceStream.Close();
                transaction.Commit();
            }
            catch (Exception e)
            {
                if (transaction != null)
                    transaction.Rollback();
                throw e;
            }
            finally
            {
                if (connection != null)
                    connection.Close();
            }
        }

        public static void ReadImage(int imageID, PictureBox pictureBox)
        {
            SqlConnection connection = null;
            SqlTransaction transaction = null;
            try
            {
                connection = GetConnection();
                connection.Open();
                transaction = connection.BeginTransaction();

                SqlCommand command = new SqlCommand();
                command.Connection = connection;
                command.Transaction = transaction;
                command.CommandText =
                    "SELECT ProductImage.PathName(), " +
                    "       GET_FILESTREAM_TRANSACTION_CONTEXT() " +
                    "FROM ProductImages " +
                    "WHERE ImageID = @ImageID";
                command.Parameters.AddWithValue("@ImageID", imageID);

                SqlDataReader reader = command.ExecuteReader();
                if (reader.Read() == false)
                {
                    throw new Exception("Unable to get path and context for BLOB.");
                }
                string path = (string)reader[0];
                byte[] context = (byte[])reader[1];
                reader.Close();

                // Set up the input stream from the database
                SqlFileStream sourceStream =
                    new SqlFileStream(path, context, FileAccess.Read);

                // Set up the output stream to the picture box
                MemoryStream targetStream = new MemoryStream();

                // Stream the data from the database to the form
                int blockSize = 1024 * 512;
                byte[] buffer = new byte[blockSize];
                int bytesRead = sourceStream.Read(buffer, 0, buffer.Length);
                while (bytesRead > 0)
                {
                    targetStream.Write(buffer, 0, buffer.Length);
                    bytesRead = sourceStream.Read(buffer, 0, buffer.Length);
                }
                pictureBox.Image = System.Drawing.Image.FromStream(targetStream);
                sourceStream.Close();
                targetStream.Close();
            }
            catch (Exception e)
            {
                throw e;
            }
            finally
            {
                if (connection != null)
                    connection.Close();
            }
        }

        public static List<int> GetImageIDList()
        {
            SqlConnection connection = null;
            try
            {
                connection = GetConnection();

                SqlCommand command = new SqlCommand();
                command.Connection = connection;
                command.CommandText = 
                    "SELECT ImageID FROM ProductImages " +
                    "ORDER BY ImageID";

                connection.Open();
                SqlDataReader reader = command.ExecuteReader();
 
                List<int> imageIDList = new List<int>();
                while (reader.Read())
                {
                    int imageID = (int)reader[0];
                    imageIDList.Add(imageID);
                }
                reader.Close();

                return imageIDList;
            }
            catch (Exception e)
            {
                throw e;
            }
            finally
            {
                if (connection != null)
                    connection.Close();
            }
        }
    }
}