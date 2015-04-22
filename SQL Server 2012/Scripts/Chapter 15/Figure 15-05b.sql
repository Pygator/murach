USE AP;

DECLARE @MyInvTotal money;
EXEC spInvTotal3 @MyInvTotal OUTPUT, '2012-02-01', 'P%';

PRINT '$' + CONVERT(varchar,@MyInvTotal,1);