USE AP;

SELECT VendorContactLName + ', ' + VendorContactFName AS [Full Name]
FROM Vendors
WHERE VendorContactLName LIKE '[A-C,E]%'
--Also acceptable:
--WHERE VendorContactLName LIKE '[A-E]%' AND
--      VendorContactLName NOT LIKE 'D%'
ORDER BY VendorContactLName, VendorContactFName;
