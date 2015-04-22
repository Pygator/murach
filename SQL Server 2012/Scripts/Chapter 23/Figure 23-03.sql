USE AP;

SELECT AVG(InvoiceTotal) AS InvoiceTotalAvg,
       MIN(InvoiceTotal) AS InvoiceTotalMin,
       MAX(InvoiceTotal) AS InvoiceTotalMax,
       dbo.TrimmedAvg(InvoiceTotal) AS InvoiceTotalTrimmedAvg
FROM Invoices;