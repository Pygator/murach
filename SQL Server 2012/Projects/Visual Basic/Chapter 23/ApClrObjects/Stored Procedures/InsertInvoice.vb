Imports System
Imports System.Data
Imports System.Data.SqlClient
Imports System.Data.SqlTypes
Imports Microsoft.SqlServer.Server


Partial Public Class StoredProcedures
    <Microsoft.SqlServer.Server.SqlProcedure()> _
    Public Shared Function InsertInvoice(
            ByVal vendorID As SqlInt32,
            ByVal invoiceNumber As SqlString,
            ByVal invoiceDate As SqlDateTime,
            ByVal invoiceTotal As SqlMoney,
            ByVal paymentTotal As SqlMoney,
            ByVal creditTotal As SqlMoney,
            ByVal termsID As SqlInt32,
            ByVal invoiceDueDate As SqlDateTime) _
            As SqlInt32
        ' Validate any parameters that need to be validated
        If invoiceNumber.IsNull OrElse invoiceNumber = "" Then
            Throw New ApplicationException("Invalid invoice number. " &
                "You must specify and invoice number.")
        End If
        If invoiceDate.IsNull Then
            Throw New ApplicationException("Invalid invoice date. " &
                "You must specify an invoice date.")
        End If
        If invoiceDate > DateTime.Today Then
            Throw New ApplicationException("Invalid invoice date. " &
                "The invoice date cannot be in the future.")
        End If
        If invoiceTotal.IsNull Then
            Throw New ApplicationException("Invalid invoice total. " &
                "You must specify an invoice total.")
        End If
        If invoiceTotal <= 0 Then
            Throw New ApplicationException("Invalid invoice total. " &
                "Invoice total must be greater than zero.")
        End If
        If paymentTotal.IsNull Then
            paymentTotal = 0
        End If
        If creditTotal.IsNull Then
            creditTotal = 0
        End If

        ' If necessary, validate other parameters here

        ' Open the Connection object for the context
        Dim connection As New SqlConnection("Context connection=true")
        connection.Open()

        ' Create the Command object
        Dim command As New SqlCommand
        command.Connection = connection

        ' Validate the VendorID
        Dim sql As String = "SELECT * FROM Vendors " &
                            "WHERE VendorID = @VendorID"
        command.CommandText = sql
        Dim param As New SqlParameter("@VendorID", vendorID)
        command.Parameters.Add(param)
        Dim reader As SqlDataReader = command.ExecuteReader
        If reader.Read = False Then
            reader.Close()
            Throw New ApplicationException("Invalid Vendor ID. " &
                "Vendor ID does not exist.")
        Else
            reader.Close()
        End If

        ' If necessary, perform any other validation
        ' that requires a database lookup here

        ' Create the Insert query
        sql = "INSERT Invoices VALUES (" &
              "@VendorID, @InvoiceNumber, @InvoiceDate, " &
              "@InvoiceTotal, @Paymenttotal, @CreditTotal, " &
              "@TermsID, @InvoiceDueDate, NULL)"
        command.CommandText = sql

        ' Clear the Parameters collection
        command.Parameters.Clear()

        ' Add all parameters to the Parameters collection
        param = New SqlParameter("@VendorID", SqlDbType.Int)
        param.Value = vendorID
        command.Parameters.Add(param)

        param = New SqlParameter("@InvoiceNumber", SqlDbType.VarChar)
        param.Value = invoiceNumber
        command.Parameters.Add(param)

        param = New SqlParameter("@InvoiceDate", SqlDbType.DateTime)
        param.Value = invoiceDate
        command.Parameters.Add(param)

        param = New SqlParameter("@InvoiceTotal", SqlDbType.Money)
        param.Value = invoiceTotal
        command.Parameters.Add(param)

        param = New SqlParameter("@Paymenttotal", SqlDbType.Money)
        param.Value = paymentTotal
        command.Parameters.Add(param)

        param = New SqlParameter("@CreditTotal", SqlDbType.Money)
        param.Value = creditTotal
        command.Parameters.Add(param)

        param = New SqlParameter("@TermsID", SqlDbType.Int)
        param.Value = termsID
        command.Parameters.Add(param)

        param = New SqlParameter("@InvoiceDueDate", SqlDbType.DateTime)
        param.Value = invoiceDueDate
        command.Parameters.Add(param)

        ' Execute the query
        command.ExecuteNonQuery()

        ' Get the new invoice ID
        sql = "SELECT MAX(IDENT_CURRENT('Invoices')) AS InvoiceID " &
              "FROM Invoices"
        command.CommandText = sql
        command.Parameters.Clear()
        Dim newInvoiceID As Integer = CInt(command.ExecuteScalar)

        ' Close the Connection object
        connection.Close()

        ' Return the invoice ID
        Return CType(newInvoiceID, SqlInt32)
    End Function

    ' A method that provides for default values
    <Microsoft.SqlServer.Server.SqlProcedure()> _
    Public Shared Function InsertInvoiceWithDefaultValues(
            ByVal vendorID As Integer,
            ByVal invoiceNumber As String,
            ByVal invoiceDate As DateTime,
            ByVal invoiceTotal As Decimal) _
            As SqlInt32
        ' Assign default values
        Dim paymentTotal As Decimal = 0
        Dim creditTotal As Decimal = 0
        Dim termsID As Integer = 3  ' or look up default termsID for vendor
        Dim invoiceDueDate As DateTime =
            invoiceDate.AddDays(30)  ' or add the number of days specified
        ' by the termsID

        ' Send all values to the InsertInvoice method
        Dim invoiceID As SqlInt32 = InsertInvoice(vendorID, invoiceNumber,
            invoiceDate, invoiceTotal, paymentTotal, creditTotal, termsID,
            invoiceDueDate)

        Return invoiceID
    End Function
End Class
