USE AP;

-- The subquery
SELECT TOP 5 VendorID, AVG(InvoiceTotal) AS AvgInvoice
FROM Invoices
GROUP BY VendorID
ORDER BY AvgInvoice DESC;
