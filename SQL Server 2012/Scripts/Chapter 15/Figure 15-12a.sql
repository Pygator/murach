USE AP;

IF OBJECT_ID('fnVendorID') IS NOT NULL
    DROP FUNCTION fnVendorID;
GO

CREATE FUNCTION fnVendorID
    (@VendorName varchar(50))
    RETURNS int
BEGIN
    RETURN (SELECT VendorID FROM Vendors WHERE VendorName = @VendorName);
END;
