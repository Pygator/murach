USE AP;
IF OBJECT_ID('GetInvoiceTotalSum') IS NOT NULL
    DROP PROC GetInvoiceTotalSum;
GO

CREATE PROC GetInvoiceTotalSum
    @InvoiceTotalSum money OUTPUT,
    @StartDate smalldatetime,
    @VendorName nvarchar(40)
AS
EXTERNAL NAME ApClrObjects.StoredProcedures.GetInvoiceTotalSum;