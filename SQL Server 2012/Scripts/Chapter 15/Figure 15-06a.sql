USE AP;

IF OBJECT_ID('spInvCount') IS NOT NULL
    DROP PROC spInvCount;
GO

CREATE PROC spInvCount
       @DateVar smalldatetime = NULL,
       @VendorVar varchar(40) = '%'
AS

IF @DateVar IS NULL
   SELECT @DateVar = MIN(InvoiceDate) FROM Invoices;

DECLARE @InvCount int;

SELECT @InvCount = COUNT(InvoiceID)
FROM Invoices JOIN Vendors
    ON Invoices.VendorID = Vendors.VendorID
WHERE (InvoiceDate >= @DateVar) AND
       (VendorName LIKE @VendorVar);

RETURN @InvCount;