USE AP;
GO

CREATE FUNCTION fnUnpaidInvoiceID()
RETURNS int
BEGIN
    RETURN
    (SELECT MIN(InvoiceID)
     FROM Invoices
     WHERE InvoiceTotal - CreditTotal - PaymentTotal > 0 AND
           InvoiceDueDate =
     (SELECT MIN(InvoiceDueDate)
      FROM Invoices
      WHERE InvoiceTotal - CreditTotal - PaymentTotal > 0));
END;
