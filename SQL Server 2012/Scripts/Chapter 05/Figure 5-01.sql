USE AP;

SELECT COUNT(*) AS NumberOfInvoices,
    SUM(InvoiceTotal - PaymentTotal - CreditTotal) AS TotalDue
FROM Invoices
WHERE InvoiceTotal - PaymentTotal - CreditTotal > 0;

