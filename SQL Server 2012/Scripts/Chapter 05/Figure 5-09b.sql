USE AP;

SELECT VendorState, VendorCity, VendorZipCode, 
       COUNT(*) AS QtyVendors
FROM Vendors
WHERE VendorState IN ('IA', 'NJ')
GROUP BY GROUPING SETS((VendorState, VendorCity), VendorZipCode, ())
ORDER BY VendorState DESC, VendorCity DESC;
