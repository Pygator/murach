USE AP;
GO

CREATE PROC spDateRange
       @DateMin varchar(50) = NULL,
       @DateMax varchar(50) = NULL
AS

IF @DateMin IS NULL OR @DateMax IS NULL
	THROW 50001, 'The DateMin and DateMax parameters are required.', 1;
IF NOT (ISDATE(@DateMin) = 1 AND ISDATE(@DateMax) = 1)
	THROW 50001, 'The date format is not valid. Please use mm/dd/yy.', 1;
IF CAST(@DateMin AS datetime) > CAST(@DateMax AS datetime)
	THROW 50001, 'The DateMin parameter must be earlier than DateMax', 1;

SELECT InvoiceNumber, InvoiceDate, InvoiceTotal,
       InvoiceTotal - CreditTotal - PaymentTotal AS Balance
FROM Invoices
WHERE InvoiceDate BETWEEN @DateMin AND @DateMax
ORDER BY InvoiceDate;