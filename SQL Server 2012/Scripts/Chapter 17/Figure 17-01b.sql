USE AP;

DECLARE @InvoiceID int;
BEGIN TRY
    BEGIN TRAN;
    INSERT Invoices
      VALUES (34,'ZXA-080','2012-04-30',14092.59,0,0,3,'2012-05-30',NULL);
    SET @InvoiceID = @@IDENTITY;
    INSERT InvoiceLineItems VALUES (@InvoiceID,1,160,4447.23,'HW upgrade');
    INSERT InvoiceLineItems
      VALUES (@InvoiceID,2,167,9645.36,'OS upgrade');
    COMMIT TRAN;
END TRY
BEGIN CATCH
    ROLLBACK TRAN;
END CATCH;