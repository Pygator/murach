USE AP;
GO

ALTER TRIGGER Vendors_INSERT_UPDATE
    ON Vendors
    AFTER INSERT,UPDATE
AS
    UPDATE Vendors
    SET VendorState = UPPER(VendorState),
        VendorAddress1 = LTRIM(RTRIM(VendorAddress1)),
        VendorAddress2 = LTRIM(RTRIM(VendorAddress2))
    WHERE VendorID IN (SELECT VendorID FROM Inserted);
