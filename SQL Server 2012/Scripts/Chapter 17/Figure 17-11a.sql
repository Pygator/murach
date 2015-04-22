USE AP;

SET TRANSACTION ISOLATION LEVEL REPEATABLE READ;
DECLARE @InvoiceTotal money;

BEGIN TRAN;
    SELECT @InvoiceTotal = SUM(InvoiceLineItemAmount)
    FROM InvoiceLineItems
    WHERE InvoiceID = 101;

WAITFOR DELAY '00:00:05';

    UPDATE Invoices
    SET InvoiceTotal = @InvoiceTotal
    WHERE InvoiceID = 101;
COMMIT TRAN;
