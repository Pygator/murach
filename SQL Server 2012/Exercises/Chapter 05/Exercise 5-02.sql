USE AP;

SELECT TOP 10 VendorName, SUM(PaymentTotal) AS PaymentSum
FROM Vendors JOIN Invoices
  ON Vendors.VendorID = Invoices.VendorID
GROUP BY VendorName
ORDER BY PaymentSum DESC;
