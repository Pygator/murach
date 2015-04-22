DECLARE @InvoiceTotalSumOut money;
EXEC GetInvoiceTotalSum
	@InvoiceTotalSum = @InvoiceTotalSumOut OUTPUT, 
	@StartDate = '2008-06-01', 
	@VendorName = 'P%';
PRINT '$' + CONVERT(varchar, @InvoiceTotalSumOut, 1);