USE AP;
DECLARE @TableNameVar varchar(128);
SET @TableNameVar = 'Invoices';
EXEC ('SELECT * FROM ' + @TableNameVar + ';');