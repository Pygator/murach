Imports System.Data.SqlClient

Public Class VendorDB

    Public Shared Function GetVendor(vendorID As Integer) As Vendor
        Dim vendor As New Vendor

        ' Create the connection object
        Dim connection As New SqlConnection()
        connection.ConnectionString = "Data Source=localhost\SqlExpress;" &
            "Initial Catalog=AP;Integrated Security=True"

        ' Create the command object and set the connection,
        ' SELECT statement, and parameter value
        Dim selectCommand As New SqlCommand
        selectCommand.Connection = connection
        selectCommand.CommandText = "SELECT VendorID, " &
            "VendorName, VendorAddress1, VendorAddress2, " &
            "VendorCity, VendorState, VendorZipCode " &
            "FROM Vendors WHERE VendorID = @VendorID"
        selectCommand.Parameters.AddWithValue("@VendorID", vendorID)

        ' Open the connection to the database
        connection.Open()

        ' Retrieve the row specified by the SELECT statement
        ' and load it into the Vendor object
        Dim reader As SqlDataReader = selectCommand.ExecuteReader
        If reader.Read Then
            vendor.VendorID = CInt(reader("VendorID"))
            vendor.VendorName = reader("VendorName").ToString
            vendor.VendorAddress1 = reader("VendorAddress1").ToString
            vendor.VendorAddress2 = reader("VendorAddress2").ToString
            vendor.VendorCity = reader("VendorCity").ToString
            vendor.VendorState = reader("VendorState").ToString
            vendor.VendorZipCode = reader("VendorZipCode").ToString
        Else
            vendor = Nothing
        End If
        reader.Close()

        ' Close the connection to the database
        connection.Close()

        Return vendor
    End Function

End Class
