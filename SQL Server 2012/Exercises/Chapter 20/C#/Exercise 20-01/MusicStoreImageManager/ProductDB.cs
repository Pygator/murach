using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.IO;
using System.Windows.Forms;

namespace MusicStoreImageManager
{
    class ProductDB
    {
        // The directory for the images
        static string imagesPath = "C:/Murach/SQL Server 2012/Images/";

        public static SqlConnection GetConnection()
        {
            SqlConnection connection = new SqlConnection();
            connection.ConnectionString = 
                "Data Source=localhost\\SqlExpress;" + 
                "Initial Catalog=Examples;Integrated Security=True";
            return connection;
        }

        public static void WriteImage(int productID, string imageName)
        {
            SqlConnection connection = null;
            try
            {
                // 1. Read image from file
                string filepath = imagesPath + imageName;
                if (File.Exists(filepath) == false)
                {
                    throw new Exception("File Not Found: " + filepath);
                }
                FileStream sourceStream = new FileStream(
                    filepath,
                    FileMode.Open,
                    FileAccess.Read);

                int streamLength = (int) sourceStream.Length;
                Byte[] productImage = new Byte[streamLength];
                sourceStream.Read(productImage, 0, streamLength);
                sourceStream.Close();

                // 2. Write image to database
                connection = GetConnection();

                SqlCommand command = new SqlCommand();
                command.Connection = connection;
                command.CommandText =
                    "INSERT INTO ProductImages " +
                    "VALUES (@ProductID, @ProductImage)";
                command.Parameters.AddWithValue("@ProductID", productID);
                command.Parameters.AddWithValue("@ProductImage", productImage);

                connection.Open();
                command.ExecuteNonQuery();
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

        public static void ReadImage(int imageID, PictureBox pictureBox)
        {
            SqlConnection connection = null;
            try
            {
                connection = GetConnection();

                SqlCommand command = new SqlCommand();
                command.Connection = connection;
                command.CommandText =
                    "SELECT ProductImage " +
                    "FROM ProductImages " +
                    "WHERE ImageID = @ImageID";
                command.Parameters.AddWithValue("@ImageID", imageID);

                connection.Open();
                SqlDataReader reader = command.ExecuteReader();

                Byte[] imageByteArray = null;
                if (reader.Read() == false)
                {
                    throw new Exception("Unable to read image.");
                }
                imageByteArray = (Byte[]) reader[0];
                reader.Close();

                MemoryStream ms = new MemoryStream(imageByteArray);
                pictureBox.Image = System.Drawing.Image.FromStream(ms);
                ms.Close();
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