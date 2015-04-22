USE AP;

SELECT VendorID, VendorName, VendorState
FROM Vendors
WHERE NOT EXISTS
    (SELECT *
    FROM Invoices
    WHERE Invoices.VendorID = Vendors.VendorID);

