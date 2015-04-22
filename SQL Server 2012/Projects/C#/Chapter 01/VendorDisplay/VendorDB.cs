using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data.SqlClient;

namespace VendorDisplay
{
    public class VendorDB
    {
        public static Vendor GetVendor(int vendorID)
        {
            Vendor vendor = new Vendor();

            // Create the connection object
            SqlConnection connection = new SqlConnection();
            connection.ConnectionString = "Data Source=localhost\\SqlExpress;" +
                "Initial Catalog=AP;Integrated Security=True";

            // Create the command object and set the connection,
            // SELECT statement, and parameter value
            SqlCommand selectCommand = new SqlCommand();
            selectCommand.Connection = connection;
            selectCommand.CommandText = "SELECT VendorID, " +
                "VendorName, VendorAddress1, VendorAddress2, " +
                "VendorCity, VendorState, VendorZipCode " +
                "FROM Vendors WHERE VendorID = @VendorID";
            selectCommand.Parameters.AddWithValue("@VendorID", vendorID);

            // Open the connection to the database
            connection.Open();

            // Retrieve the row specified by the SELECT statement
            // and load it into the Vendor object
            SqlDataReader reader = selectCommand.ExecuteReader();
            if (reader.Read())
            {
                vendor.VendorID = (int)reader["VendorID"];
                vendor.VendorName = reader["VendorName"].ToString();
                vendor.VendorAddress1 = reader["VendorAddress1"].ToString();
                vendor.VendorAddress2 = reader["VendorAddress2"].ToString();
                vendor.VendorCity = reader["VendorCity"].ToString();
                vendor.VendorState = reader["VendorState"].ToString();
                vendor.VendorZipCode = reader["VendorZipCode"].ToString();
            }
            else
            {
                vendor = null;
            }
            reader.Close();

            // Close the connection to the database
            connection.Close();

            return vendor;
        }
    }
}
