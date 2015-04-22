USE AP;

DECLARE Vendors_Cursor CURSOR
STATIC
FOR
    SELECT VendorID, VendorName
    FROM Vendors
    ORDER BY VendorName;

OPEN Vendors_Cursor;
FETCH NEXT FROM Vendors_Cursor;
WHILE @@FETCH_STATUS = 0
    FETCH NEXT FROM Vendors_Cursor;
CLOSE Vendors_Cursor;
DEALLOCATE Vendors_Cursor;
