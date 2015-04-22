DECLARE @email Email;

BEGIN TRY
	SET @email = 'mike@murach.com';
END TRY
BEGIN CATCH
	PRINT CONVERT(varchar(500), ERROR_MESSAGE());
END CATCH;

IF @email IS NULL
	BEGIN
		PRINT '@email IS NULL';
	END
ELSE
	BEGIN
		PRINT 'Email address: ' + Convert(varchar(50), @email);
		PRINT 'Email username: ' + @email.Username;
		PRINT 'Email domain: ' + @email.Domain;
	END