USE AP;

SELECT 'After 9/1/2011' AS SelectionDate, COUNT(*) AS NumberOfInvoices,
    MAX(InvoiceTotal) AS HighestInvoiceTotal,
    MIN(InvoiceTotal) AS LowestInvoiceTotal
FROM Invoices
WHERE InvoiceDate > '2011-09-01';
