USE AP;
DECLARE @EarliestInvoiceDue smalldatetime;
SELECT @EarliestInvoiceDue = MIN(InvoiceDueDate) FROM Invoices 
    WHERE InvoiceTotal - PaymentTotal - CreditTotal > 0;
IF @EarliestInvoiceDue < GETDATE()
    PRINT 'Outstanding invoices overdue!';