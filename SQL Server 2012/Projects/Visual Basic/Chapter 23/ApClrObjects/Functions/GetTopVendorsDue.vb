Imports System
Imports System.Data
Imports System.Data.SqlClient
Imports System.Data.SqlTypes
Imports Microsoft.SqlServer.Server

' add this namespace
Imports System.Collections

Partial Public Class UserDefinedFunctions
    <Microsoft.SqlServer.Server.SqlFunction(
    TableDefinition:="VendorName nvarchar(50), TotalDue money",
    FillRowMethodName:="FillRow",
    DataAccess:=DataAccessKind.Read)> _
    Public Shared Function GetTopVendorsDue(ByVal cutOff As SqlMoney) As IEnumerable
        ' Open the Connection object for the context
        Dim connection As New SqlConnection("Context connection=true")
        connection.Open()

        ' Create the Command object
        Dim command As New SqlCommand()
        command.Connection = connection
        command.CommandText =
            "SELECT VendorName, SUM(InvoiceTotal) As TotalDue " &
            "FROM Vendors " &
            "    JOIN Invoices ON Vendors.VendorID = Invoices.VendorID " &
            "WHERE InvoiceTotal - PaymentTotal - CreditTotal > 0 " &
            "GROUP BY VendorName " &
            "HAVING SUM(InvoiceTotal) >= @CutOff"

        ' Add the parameter to the Command object
        Dim param As New SqlParameter("@CutOff", SqlDbType.Money)
        param.Value = cutOff
        command.Parameters.Add(param)

        ' Get the DataSet object and return the rows from the first table
        Dim adapter As New SqlDataAdapter(command)
        Dim dataSet As New DataSet()
        adapter.Fill(dataSet)
        Dim rows As DataRowCollection = dataSet.Tables(0).Rows

        ' Close the connection and return the rows
        connection.Close()
        Return rows
    End Function

    Private Shared Sub FillRow(ByVal rowObject As Object, ByRef vendorName As SqlString,
            ByRef totalDue As SqlMoney)
        Dim row As DataRow = CType(rowObject, DataRow)
        vendorName = row("VendorName").ToString
        totalDue = CDec(row("TotalDue"))
    End Sub
End Class
