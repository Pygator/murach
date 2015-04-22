USE AP;

  SELECT VendorName, VendorState
  FROM Vendors
  WHERE VendorState = 'CA'
UNION
  SELECT VendorName, 'Outside CA'
  FROM Vendors
  WHERE VendorState <> 'CA'
ORDER BY VendorName;
