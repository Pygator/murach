Imports System
Imports System.Data
Imports System.Data.SqlClient
Imports System.Data.SqlTypes
Imports Microsoft.SqlServer.Server


Partial Public Class StoredProcedures
    <Microsoft.SqlServer.Server.SqlProcedure()> _
    Public Shared Sub  GetTop10Vendors ()
        Dim connection As New SqlConnection("Context connection=true")
        connection.Open()


        Dim sql As String =
            "SELECT TOP 10 VendorName, SUM(InvoiceTotal) " &
            "AS InvoiceTotal " &
            "FROM Invoices JOIN Vendors " &
            "ON Invoices.VendorID = Vendors.VendorID " &
            "GROUP BY VendorName " &
            "ORDER BY SUM(InvoiceTotal) DESC"

        Dim selectCommand As New SqlCommand(sql, connection)

        Dim pipe As SqlPipe = SqlContext.Pipe
        pipe.ExecuteAndSend(selectCommand)

        connection.Close()
    End Sub
End Class
