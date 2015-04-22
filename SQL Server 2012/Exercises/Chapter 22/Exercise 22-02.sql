BEGIN TRY
    DECLARE @LineItemCount int;
    EXEC GETLineItemCountDateRange @LineItemCount OUTPUT, '2012-01-01', '2012-03-31';
    PRINT 'Line item count: ' + CONVERT(varchar, @LineItemCount);
END TRY
BEGIN CATCH
    PRINT 'Error number: ' + CONVERT(varchar, ERROR_NUMBER());
    PRINT 'Error message: ' + CONVERT(varchar(500), ERROR_MESSAGE());
END CATCH;
