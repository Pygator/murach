USE AP;

SELECT VendorID, SUM(InvoiceTotal) AS SumInvoices,
    IIF(SUM(InvoiceTotal) < 1000, 'Low', 'High') AS InvoiceRange
FROM Invoices
GROUP BY VendorID;

