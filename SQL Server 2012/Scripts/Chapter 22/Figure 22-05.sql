USE AP;

BEGIN TRY
    DECLARE @InvoiceID int;
    EXEC @InvoiceID = InsertInvoiceTest
         @InvoiceNumber = 'RZ99381';
    PRINT 'New InvoiceID: ' + CONVERT(varchar, @InvoiceID);
END TRY
BEGIN CATCH
    PRINT 'Error number: ' + CONVERT(varchar, ERROR_NUMBER());
    PRINT 'Error message: ' + CONVERT(varchar(500), ERROR_MESSAGE());
END CATCH;