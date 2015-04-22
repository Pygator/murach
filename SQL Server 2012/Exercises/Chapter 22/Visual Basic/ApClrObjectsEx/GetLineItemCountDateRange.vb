Imports System
Imports System.Data
Imports System.Data.SqlClient
Imports System.Data.SqlTypes
Imports Microsoft.SqlServer.Server


Partial Public Class StoredProcedures
    <Microsoft.SqlServer.Server.SqlProcedure()> _
    Public Shared Sub GetLineItemCountDateRange(
            ByRef lineItemCount As SqlInt32,
            ByVal startDate As SqlDateTime,
            ByVal endDate As SqlDateTime)
        If startDate.IsNull Then
            Throw New ApplicationException("Invalid start date. " &
                "You must specify a start date.")
        End If
        If startDate > DateTime.Today Then
            Throw New ApplicationException("Invalid start date. " &
                "The start date can't be in the future.")
        End If
        If endDate.IsNull Then
            endDate = DateTime.Today
        End If
        If endDate < startDate Then
            Throw New ApplicationException("Invalid end date. " &
                "The end date can't be before the start date.")
        End If
        Dim connection As New SqlConnection("Context connection=true")
        connection.Open()

        Dim sql As String =
            "SELECT COUNT(*) " &
            "FROM InvoiceLineItems JOIN Invoices " &
            "ON InvoiceLineItems.InvoiceID = Invoices.InvoiceID " &
            "WHERE ((InvoiceDate >= @StartDate) AND " &
            "       (InvoiceDate <= @EndDate))"

        Dim command As New SqlCommand(sql, connection)

        Dim param As New SqlParameter("@StartDate", SqlDbType.DateTime)
        param.Value = startDate
        command.Parameters.Add(param)

        param = New SqlParameter("@EndDate", SqlDbType.DateTime)
        param.Value = endDate
        command.Parameters.Add(param)

        Try
            Dim scalarValue As Integer = CInt(command.ExecuteScalar)
            lineItemCount = CType(scalarValue, SqlInt32)
        Catch ex As Exception
            lineItemCount = 0
        End Try

        connection.Close()
    End Sub
End Class
