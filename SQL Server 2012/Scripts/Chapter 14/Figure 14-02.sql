USE AP;
DECLARE @TotalDue money;
SET @TotalDue = (SELECT SUM(InvoiceTotal - PaymentTotal - CreditTotal)
    FROM Invoices);
IF @TotalDue > 0
    PRINT 'Total invoices due = $' + CONVERT(varchar,@TotalDue,1);
ELSE
    PRINT 'Invoices paid in full';