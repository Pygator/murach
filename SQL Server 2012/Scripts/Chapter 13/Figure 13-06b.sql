USE AP;
GO

ALTER VIEW Vendors_SW
AS
SELECT *
FROM Vendors
WHERE VendorState IN ('CA','AZ','NV','NM','UT','CO');
