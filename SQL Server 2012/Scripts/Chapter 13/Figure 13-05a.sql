USE AP;
GO

CREATE VIEW InvoiceCredit
AS
SELECT InvoiceNumber, InvoiceDate, InvoiceTotal, PaymentTotal, CreditTotal
FROM Invoices
WHERE InvoiceTotal - PaymentTotal - CreditTotal > 0;
