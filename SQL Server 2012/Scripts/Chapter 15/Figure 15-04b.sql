USE AP;

IF OBJECT_ID('spInvTotal2') IS NOT NULL
    DROP PROC spInvTotal2;
GO

CREATE PROC spInvTotal2
       @DateVar smalldatetime = NULL
AS
IF @DateVar IS NULL
    SELECT @DateVar = MIN(InvoiceDate) FROM Invoices;
SELECT SUM(InvoiceTotal)
FROM Invoices
WHERE InvoiceDate >= @DateVar;