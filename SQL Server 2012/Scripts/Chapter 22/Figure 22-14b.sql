USE AP;

UPDATE Vendors
SET VendorState = 'ca'
WHERE VendorName = 'IBM';

SELECT VendorID, VendorName, VendorState 
FROM Vendors 
WHERE VendorName = 'IBM';