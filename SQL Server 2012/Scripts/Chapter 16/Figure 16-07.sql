USE AP;

DECLARE Vendor_Cursor CURSOR
STATIC
FOR
    SELECT VendorID, VendorName FROM Vendors ORDER BY VendorName;

DECLARE  @VendorIDVar int, @VendorNameVar varchar(50);

OPEN Vendor_Cursor;
IF @@CURSOR_ROWS > 0
    BEGIN
        FETCH NEXT FROM Vendor_Cursor INTO @VendorIDVar, @VendorNameVar;
        WHILE @@FETCH_STATUS = 0
            BEGIN
                PRINT CONVERT(varchar,@VendorIDVar) + ', ' + @VendorNameVar;
                FETCH RELATIVE 20 FROM Vendor_Cursor
                INTO @VendorIDVar, @VendorNameVar;
            END;
    END;
CLOSE Vendor_Cursor;
DEALLOCATE Vendor_Cursor;