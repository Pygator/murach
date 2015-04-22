USE AP;

SET TRANSACTION ISOLATION LEVEL REPEATABLE READ;
DECLARE @InvoiceTotal money;

BEGIN TRAN;
    SELECT @InvoiceTotal = InvoiceTotal
    FROM Invoices
    WHERE InvoiceID = 101;

    UPDATE InvoiceLineItems
    SET InvoiceLineItemAmount = @InvoiceTotal
    WHERE InvoiceID = 101 AND InvoiceSequence = 1;
COMMIT TRAN;
