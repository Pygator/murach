USE AP;

IF OBJECT_ID('OutstandingInvoices') IS NOT NULL
    DROP VIEW OutstandingInvoices;
GO

CREATE VIEW OutstandingInvoices
AS
SELECT InvoiceNumber, InvoiceDate, InvoiceTotal,
    InvoiceTotal - PaymentTotal - CreditTotal AS BalanceDue
FROM Invoices
WHERE InvoiceTotal - PaymentTotal - CreditTotal > 0;
