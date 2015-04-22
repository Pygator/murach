USE AP;

INSERT VendorCopy
SELECT VendorName, VendorAddress1, VendorAddress2,
       VendorCity, VendorState, VendorZipCode,
       VendorPhone, VendorContactLName, VendorContactFName,
       DefaultTermsID, DefaultAccountNo
FROM Vendors
WHERE VendorState <> 'CA';
