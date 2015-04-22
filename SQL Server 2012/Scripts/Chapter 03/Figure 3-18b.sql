USE AP;

SELECT VendorName, VendorCity, VendorState, VendorZipCode
FROM Vendors
WHERE VendorState = 'CA'
ORDER BY VendorCity
    OFFSET 10 ROWS	
    FETCH NEXT 10 ROWS ONLY;
