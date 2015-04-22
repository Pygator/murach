USE AP;

PRINT 'Balance due: $' + CONVERT(varchar, dbo.fnBalanceDue(), 1);
