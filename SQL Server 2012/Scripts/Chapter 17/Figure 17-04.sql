USE AP;

IF OBJECT_ID('tempdb..#VendorCopy') IS NOT NULL
    DROP TABLE tempdb.. #VendorCopy;
SELECT VendorID, VendorName
INTO #VendorCopy
FROM Vendors
WHERE VendorID < 5;
BEGIN TRAN;
  DELETE #VendorCopy WHERE VendorID = 1;
  SAVE TRAN Vendor1;
    DELETE #VendorCopy WHERE VendorID = 2;
    SAVE TRAN Vendor2;
      DELETE #VendorCopy WHERE VendorID = 3;
      SELECT * FROM #VendorCopy;
    ROLLBACK TRAN Vendor2;
    SELECT * FROM #VendorCopy;
  ROLLBACK TRAN Vendor1;
  SELECT * FROM #VendorCopy;
COMMIT TRAN;
SELECT * FROM #VendorCopy;