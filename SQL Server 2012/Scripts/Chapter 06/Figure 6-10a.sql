USE AP;

SELECT DISTINCT VendorName,
    (SELECT MAX(InvoiceDate) FROM Invoices
    WHERE Invoices.VendorID = Vendors.VendorID) AS LatestInv
FROM Vendors
ORDER BY LatestInv DESC;

