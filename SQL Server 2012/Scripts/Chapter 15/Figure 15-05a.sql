USE AP;

IF OBJECT_ID('spInvTotal3') IS NOT NULL
    DROP PROC spInvTotal3;
GO

CREATE PROC spInvTotal3
       @InvTotal money OUTPUT,
       @DateVar smalldatetime = NULL,
       @VendorVar varchar(40) = '%'
AS

IF @DateVar IS NULL
   SELECT @DateVar = MIN(InvoiceDate) FROM Invoices;

SELECT @InvTotal = SUM(InvoiceTotal)
FROM Invoices JOIN Vendors
    ON Invoices.VendorID = Vendors.VendorID
WHERE (InvoiceDate >= @DateVar) AND
      (VendorName LIKE @VendorVar);