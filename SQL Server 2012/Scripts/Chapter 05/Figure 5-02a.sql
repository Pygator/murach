USE AP;

SELECT 'After 9/1/2011' AS SelectionDate, COUNT(*) AS NumberOfInvoices,
    AVG(InvoiceTotal) AS AverageInvoiceAmount,
    SUM(InvoiceTotal) AS TotalInvoiceAmount
FROM Invoices
WHERE InvoiceDate > '2011-09-01';

