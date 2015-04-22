SELECT dbo.CommaDelimitedList(VendorName) AS VendorsInNY, 
       COUNT(VendorName) AS Count
FROM Vendors
WHERE VendorState = 'NY';