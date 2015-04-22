Imports System
Imports System.Data
Imports System.Data.SqlClient
Imports System.Data.SqlTypes
Imports Microsoft.SqlServer.Server


Partial Public Class Triggers
    <Microsoft.SqlServer.Server.SqlTrigger(Target:="Invoices", Event:="AFTER INSERT, UPDATE")> _
    Public Shared Sub Invoices_Update_Shipping()
        Dim connection As New SqlConnection("Context connection=true")
        connection.Open()

        Dim command As New SqlCommand()
        command.Connection = connection

        Dim tc As SqlTriggerContext = SqlContext.TriggerContext
        Dim sql As String
        If tc.TriggerAction = TriggerAction.Insert Then
            sql = "INSERT ShippingLabels " &
                  "SELECT VendorName, VendorAddress1, VendorAddress2, " &
                  "VendorCity, VendorState, VendorZipCode " &
                  "FROM Vendors JOIN Inserted " &
                  "ON Vendors.VendorID = (SELECT VendorID FROM Inserted) " &
                  "WHERE Inserted.InvoiceTotal = Inserted.PaymentTotal"
        Else
            sql = "INSERT ShippingLabels " &
                  "SELECT VendorName, VendorAddress1, VendorAddress2, " &
                  "VendorCity, VendorState, VendorZipCode " &
                  "FROM Vendors JOIN Inserted " &
                  "ON Vendors.VendorID = (SELECT VendorID FROM Inserted) " &
                  "WHERE Inserted.InvoiceTotal - Inserted.PaymentTotal - " &
                 "Inserted.CreditTotal = 0"
        End If

        command.CommandText = sql

        command.ExecuteNonQuery()

        connection.Close()
    End Sub
End Class
