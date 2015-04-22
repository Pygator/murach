Imports System
Imports System.Data
Imports System.Data.SqlClient
Imports System.Data.SqlTypes
Imports Microsoft.SqlServer.Server

Partial Public Class UserDefinedFunctions
    <Microsoft.SqlServer.Server.SqlFunction(DataAccess:=DataAccessKind.Read)> _
    Public Shared Function GetBalanceDueSum() As SqlMoney
        ' Open the Connection object for the context
        Dim connection As New SqlConnection("Context connection=true")
        connection.Open()

        ' Create the Command object
        Dim command As New SqlCommand()
        command.Connection = connection
        command.CommandText =
            "SELECT SUM(InvoiceTotal - PaymentTotal - CreditTotal) " &
            "FROM Invoices " &
            "WHERE InvoiceTotal - PaymentTotal - CreditTotal > 0"

        ' Execute the query
        Dim balanceDueSum As Decimal = CDec(command.ExecuteScalar)

        ' Close the Connection object
        connection.Close()

        ' Return the value
        Return balanceDueSum
    End Function
End Class
