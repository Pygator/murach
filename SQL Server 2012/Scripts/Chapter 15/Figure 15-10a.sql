USE AP;

IF OBJECT_ID('spVendorState') IS NOT NULL
    DROP PROC spVendorState;
GO

CREATE PROC spVendorState
       @State varchar(20)
AS
SELECT VendorName
FROM Vendors
WHERE VendorState = @State;
