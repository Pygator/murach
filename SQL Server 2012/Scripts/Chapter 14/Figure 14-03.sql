USE AP;

DECLARE @MaxInvoice money, @MinInvoice money;
DECLARE @PercentDifference decimal(8,2);
DECLARE @InvoiceCount int, @VendorIDVar int;

SET @VendorIDVar = 95;
SET @MaxInvoice = (SELECT MAX(InvoiceTotal) FROM Invoices
    WHERE VendorID = @VendorIDVar);
SELECT @MinInvoice = MIN(InvoiceTotal), @InvoiceCount = COUNT(*)
FROM Invoices
WHERE VendorID = @VendorIDVar;
SET @PercentDifference = (@MaxInvoice - @MinInvoice) / @MinInvoice * 100;

PRINT 'Maximum invoice is $' + CONVERT(varchar,@MaxInvoice,1) + '.';
PRINT 'Minimum invoice is $' + CONVERT(varchar,@MinInvoice,1) + '.';
PRINT 'Maximum is ' + CONVERT(varchar,@PercentDifference) +
    '% more than minimum.';
PRINT 'Number of invoices: ' + CONVERT(varchar,@InvoiceCount) + '.';
