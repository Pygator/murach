USE AP;
IF OBJECT_ID('VendorCopy') IS NOT NULL
    DROP TABLE VendorCopy;
IF OBJECT_ID('InvoiceCopy') IS NOT NULL
    DROP TABLE InvoiceCopy;
SELECT * INTO VendorCopy FROM Vendors;
SELECT * INTO InvoiceCopy FROM Invoices;
GO

CREATE TRIGGER VendorCopy_UPDATE_DELETE_RI
    ON VendorCopy
    AFTER DELETE
AS
    IF EXISTS (SELECT * FROM Deleted JOIN InvoiceCopy
                        ON Deleted.VendorID = InvoiceCopy.VendorID)
        BEGIN
		    ;
            THROW 50002, 'VendorID in use.', 1;
            ROLLBACK TRAN;
        END;
GO

CREATE TRIGGER InvoiceCopy_INSERT_UPDATE_RI
    ON InvoiceCopy
    AFTER INSERT,UPDATE
AS
    IF NOT EXISTS (SELECT * FROM VendorCopy
                   WHERE VendorID IN (SELECT VendorID FROM Inserted))
        BEGIN
		    ;
            THROW 50001, 'Invalid VendorID.', 1;
            ROLLBACK TRAN;
        END;