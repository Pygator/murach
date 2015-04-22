USE AP;
BEGIN TRY
	INSERT Invoices
	VALUES (799, 'ZXK-799', '2012-05-07', 299.95, 0, 0,
			1, '2012-06-06', NULL);
	PRINT 'SUCCESS: Record was inserted.';
END TRY
BEGIN CATCH
	PRINT 'FAILURE: Record was not inserted.';
	-- You can use a SELECT statement to return a
	-- result set that contains data about the error
	SELECT 
		ERROR_NUMBER() AS ErrorNumber, 
		ERROR_MESSAGE() AS ErrorMessage;
END CATCH