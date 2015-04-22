Imports System
Imports System.Data
Imports System.Data.SqlClient
Imports System.Data.SqlTypes
Imports Microsoft.SqlServer.Server


Partial Public Class StoredProcedures
    <Microsoft.SqlServer.Server.SqlProcedure()> _
    Public Shared Function InsertInvoiceTest(ByVal invoiceNumber As SqlString) _
            As SqlInt32
        ' Validate the invoiceNumber parameter
        If invoiceNumber.IsNull OrElse invoiceNumber = "" Then
            Throw New ApplicationException("Invalid invoice number. " &
                "You must specify an invoice number.")
        Else
            ' Create and return a test invoice ID
            Dim newInvoiceID As Integer = 115
            Return CType(newInvoiceID, SqlInt32)
        End If
    End Function
End Class
