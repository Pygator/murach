USE AP;

SELECT VendorName, VendorCity, VendorState
FROM Vendors AS Vendors_Main
WHERE VendorCity + VendorState NOT IN
	(SELECT VendorCity + VendorState
	FROM Vendors AS Vendors_Sub
	WHERE Vendors_Sub.VendorID <> Vendors_Main.VendorID)
ORDER BY VendorState, VendorCity;