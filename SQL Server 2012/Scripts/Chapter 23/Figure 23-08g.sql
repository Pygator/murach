USE AP;

DECLARE @email Email;
SET @email = 'mike@murach.com';
PRINT 'EmailAddress: ' + CONVERT(varchar, @email);
