Imports System
Imports System.Data
Imports System.Data.SqlClient
Imports System.Data.SqlTypes
Imports Microsoft.SqlServer.Server


Partial Public Class StoredProcedures
    <Microsoft.SqlServer.Server.SqlProcedure()> _
    Public Shared Sub  GetInvoiceReport ()
        ' Open the Connection object for the context
        Dim connection As New SqlConnection("Context connection=true")
        connection.Open()

        ' Create a string that defines the Select statement
        Dim sql As String =
            "SELECT VendorName, InvoiceNumber, InvoiceDate, InvoiceTotal " &
            "FROM Invoices JOIN Vendors " &
            "ON Invoices.VendorID = Vendors.VendorID " &
            "WHERE InvoiceTotal - CreditTotal - PaymentTotal > 0"

        ' Create the Command object
        Dim selectCommand As New SqlCommand(sql, connection)

        ' Use the SqlPipe object to return the data
        Dim pipe As SqlPipe = SqlContext.Pipe
        pipe.ExecuteAndSend(selectCommand)

        ' Close the Connection object
        connection.Close()
    End Sub
End Class
