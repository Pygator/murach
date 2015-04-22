USE AP;

PRINT 'Current outstanding balance is: $' + CONVERT(varchar, dbo.GetBalanceDueSum(), 1);