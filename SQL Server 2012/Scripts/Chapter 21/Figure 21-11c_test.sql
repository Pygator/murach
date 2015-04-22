USE AP;
DECLARE @InvoiceTotalSum money;
EXEC GetInvoiceTotalSum
	@InvoiceTotalSum OUTPUT, 
	@StartDate = '2008-06-01', 
	@VendorName = 'P%';
PRINT '$' + CONVERT(varchar, @InvoiceTotalSum, 1);
