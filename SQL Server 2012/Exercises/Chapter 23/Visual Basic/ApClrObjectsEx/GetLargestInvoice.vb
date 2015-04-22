Imports System
Imports System.Data
Imports System.Data.SqlClient
Imports System.Data.SqlTypes
Imports Microsoft.SqlServer.Server

Partial Public Class UserDefinedFunctions
    <Microsoft.SqlServer.Server.SqlFunction(DataAccess:=DataAccessKind.Read)> _
    Public Shared Function GetLargestInvoice() As SqlInt32
        Dim connection As New SqlConnection("Context connection=true")
        connection.Open()

        Dim command As New SqlCommand()
        command.Connection = connection
        command.CommandText =
            "SELECT InvoiceID " &
            "FROM Invoices " &
            "WHERE InvoiceTotal = " &
            "(SELECT MAX(InvoiceTotal) FROM Invoices)"

        Dim invoiceID As Integer = CInt(command.ExecuteScalar)

        connection.Close()

        Return invoiceID
    End Function
End Class
