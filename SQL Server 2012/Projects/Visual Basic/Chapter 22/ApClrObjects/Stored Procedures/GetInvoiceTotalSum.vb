Imports System
Imports System.Data
Imports System.Data.SqlClient
Imports System.Data.SqlTypes
Imports Microsoft.SqlServer.Server


Partial Public Class StoredProcedures
    <Microsoft.SqlServer.Server.SqlProcedure()> _
    Public Shared Sub GetInvoiceTotalSum(ByRef invoiceTotalSum As SqlMoney,
            ByVal startDate As SqlDateTime, ByVal vendorName As SqlString)
        ' Open the Connection object for the context
        Dim connection As New SqlConnection("Context connection=true")
        connection.Open()

        ' Create a string that defines the Select statement
        Dim sql As String =
            "SELECT SUM(InvoiceTotal) " &
            "FROM Invoices Join Vendors " &
            "  ON Invoices.VendorID = Vendors.VendorID " &
            "WHERE ((InvoiceDate >= @StartDate) AND " &
            "       (VendorName LIKE @VendorName))"

        ' Create the Command object
        Dim command As New SqlCommand(sql, connection)

        ' Add new parameters to the Parameters collection
        Dim param As New SqlParameter("@StartDate", SqlDbType.DateTime)
        param.Value = startDate
        command.Parameters.Add(param)

        param = New SqlParameter("@VendorName", SqlDbType.VarChar)
        param.Value = vendorName
        command.Parameters.Add(param)

        ' Assign a value to the output parameter
        Try
            Dim scalarValue As Decimal = CDec(command.ExecuteScalar)
            invoiceTotalSum = CType(scalarValue, SqlMoney)
        Catch ex As Exception    ' If a null value causes the cast to throw an exception
            invoiceTotalSum = 0
        End Try

        ' Close the Connection object
        connection.Close()
    End Sub
End Class
