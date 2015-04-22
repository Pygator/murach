DECLARE @myInt MyInt32;
SET @myInt = '3';

IF @myInt IS NULL
	PRINT '@myInt IS NULL';
ELSE
	PRINT CONVERT(varchar, @myInt);