USE AP;

BEGIN TRY
    EXEC spInsertInvoice 
         799,'ZXK-799','2012-05-01',299.95,1,'2012-06-01';
END TRY
BEGIN CATCH
    PRINT 'An error occurred.';
    PRINT 'Message: ' + CONVERT(varchar, ERROR_MESSAGE());
    IF ERROR_NUMBER() >= 50000
        PRINT 'This is a custom error message.';
END CATCH;