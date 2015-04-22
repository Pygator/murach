USE AP;

SELECT VendorState, VendorCity, COUNT(*) AS QtyVendors
FROM Vendors
WHERE VendorState IN ('IA', 'NJ')
GROUP BY VendorState, VendorCity WITH CUBE
-- GROUP BY CUBE(VendorState, VendorCity) -- 2008 and later
ORDER BY VendorState DESC, VendorCity DESC;
