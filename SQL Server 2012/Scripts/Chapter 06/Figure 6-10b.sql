USE AP;

SELECT VendorName, MAX(InvoiceDate) AS LatestInv
FROM Vendors LEFT JOIN Invoices ON Vendors.VendorID = Invoices.VendorID
GROUP BY VendorName
ORDER BY LatestInv DESC;
