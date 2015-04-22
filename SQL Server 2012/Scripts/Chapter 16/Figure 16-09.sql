USE AP;

DECLARE Dynamic_Vendor_Cursor CURSOR
DYNAMIC SCROLL_LOCKS
FOR
    SELECT * FROM Vendors ORDER BY VendorName;

OPEN Dynamic_Vendor_Cursor;
FETCH Dynamic_Vendor_Cursor;
CLOSE Dynamic_Vendor_Cursor;
DEALLOCATE Dynamic_Vendor_Cursor;