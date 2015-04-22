USE AP;

SELECT VendorName + '''s Address: ',
    VendorCity + ', ' + VendorState + ' ' + VendorZipCode
FROM Vendors;
