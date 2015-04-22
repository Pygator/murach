USE AP;
GO

ALTER PROC spVendorState
      @State varchar(20) = NULL
AS
IF @State IS NULL
   SELECT VendorName
   FROM Vendors;
ELSE
   SELECT VendorName
   FROM Vendors
   WHERE VendorState = @State;
