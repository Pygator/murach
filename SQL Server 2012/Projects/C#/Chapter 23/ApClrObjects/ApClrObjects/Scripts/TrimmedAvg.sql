SELECT AVG(InvoiceTotal) As InvoiceTotalAvg,
       dbo.TrimmedAVG(InvoiceTotal) As InvoiceTotalTrimmedAvg
FROM Invoices;