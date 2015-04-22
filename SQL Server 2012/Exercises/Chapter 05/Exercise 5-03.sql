USE AP;

SELECT VendorName, COUNT(*) AS InvoiceCount,
       SUM(InvoiceTotal) AS InvoiceSum
FROM Vendors JOIN Invoices
  ON Vendors.VendorID = Invoices.VendorID
GROUP BY VendorName
ORDER BY InvoiceCount DESC;
