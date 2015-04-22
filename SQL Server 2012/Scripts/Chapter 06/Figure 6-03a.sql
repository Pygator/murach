USE AP;

SELECT VendorID, VendorName, VendorState
FROM Vendors
WHERE VendorID NOT IN
    (SELECT DISTINCT VendorID
    FROM Invoices);
