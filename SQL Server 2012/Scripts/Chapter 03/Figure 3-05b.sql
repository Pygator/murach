USE AP;

SELECT VendorName,
    VendorCity + ', ' + VendorState + ' ' + VendorZipCode AS Address
FROM Vendors;
