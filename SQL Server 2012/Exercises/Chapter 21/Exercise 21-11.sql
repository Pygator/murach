USE AP;
GO

CREATE PROC GetTop10Vendors
AS
EXTERNAL NAME ApClrObjects.StoredProcedures.GetTop10Vendors;