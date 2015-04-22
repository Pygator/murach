USE AP;

DECLARE @MyInvTotal money;
EXEC spInvTotal3 @MyInvTotal OUTPUT;

PRINT '$' + CONVERT(varchar,@MyInvTotal,1);