USE AP;

IF OBJECT_ID('GetInvoiceReport') IS NOT NULL
    DROP PROC GetInvoiceReport;
GO

CREATE PROC GetInvoiceReport
AS 
EXTERNAL NAME ApClrObjects.StoredProcedures.GetInvoiceReport;