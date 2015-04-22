USE AP;

SELECT VendorID, AVG(InvoiceTotal) AS AverageInvoiceAmount
FROM Invoices
GROUP BY VendorID
HAVING AVG(InvoiceTotal) > 2000
ORDER BY AverageInvoiceAmount DESC;

