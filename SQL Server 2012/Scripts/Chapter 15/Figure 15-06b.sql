USE AP;

DECLARE @InvCount int;
EXEC @InvCount = spInvCount '2012-02-01', 'P%';
PRINT 'Invoice count: ' + CONVERT(varchar, @InvCount);