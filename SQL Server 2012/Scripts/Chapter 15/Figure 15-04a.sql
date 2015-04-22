USE AP;

IF OBJECT_ID('spInvTotal1') IS NOT NULL
    DROP PROC spInvTotal1;
GO

CREATE PROC spInvTotal1
       @DateVar smalldatetime,
       @InvTotal money OUTPUT
AS
SELECT @InvTotal = SUM(InvoiceTotal)
FROM Invoices
WHERE InvoiceDate >= @DateVar;