USE AP;

SELECT MIN(VendorName) AS FirstVendor,
    MAX(VendorName) AS LastVendor,
    COUNT(VendorName) AS NumberOfVendors
FROM Vendors;

