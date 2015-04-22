USE AP;

DECLARE @MyInvTotal money;
EXEC spInvTotal3 @VendorVar = 'M%', @InvTotal = @MyInvTotal OUTPUT;

PRINT '$' + CONVERT(varchar,@MyInvTotal,1);