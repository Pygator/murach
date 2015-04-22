BEGIN TRY
    DECLARE @InvoiceID int;
    EXEC @InvoiceID = InsertInvoice
        @VendorID = 799,
        @InvoiceNumber = 'RZ99381',
        @InvoiceDate = '2008-09-12',
        @InvoiceTotal = 1292.45, 
	    @PaymentTotal = 0, 
	    @CreditTotal = 0, 
	    @TermsID = 3, 
	    @InvoiceDueDate = '2008-10-12';
    PRINT 'Row was inserted.';
    PRINT 'New InvoiceID: ' + CONVERT(varchar, @InvoiceID);
END TRY
BEGIN CATCH
    PRINT 'An error occurred. Row was not inserted.';
    PRINT 'Error number: ' + CONVERT(varchar, ERROR_NUMBER());
    PRINT 'Error message: ' + CONVERT(varchar(500), ERROR_MESSAGE());
END CATCH;