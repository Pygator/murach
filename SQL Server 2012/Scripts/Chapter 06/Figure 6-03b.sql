USE AP;

SELECT Vendors.VendorID, VendorName, VendorState
FROM Vendors LEFT JOIN Invoices
    ON Vendors.VendorID = Invoices.VendorID
WHERE Invoices.VendorID IS NULL;
