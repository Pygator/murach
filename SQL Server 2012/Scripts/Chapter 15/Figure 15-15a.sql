USE AP;
GO

IF OBJECT_ID('fnCreditAdj') IS NOT NULL
    DROP FUNCTION fnCreditAdj;
GO

CREATE FUNCTION fnCreditAdj (@HowMuch money)
    RETURNS @OutTable table
           (InvoiceID int, VendorID int, InvoiceNumber varchar(50),
            InvoiceDate smalldatetime, InvoiceTotal money,
            PaymentTotal money, CreditTotal money)
BEGIN
    INSERT @OutTable
        SELECT InvoiceID, VendorID, InvoiceNumber, InvoiceDate, 
               InvoiceTotal, PaymentTotal, CreditTotal
        FROM Invoices
        WHERE (InvoiceTotal - CreditTotal - PaymentTotal) > 0;
    WHILE (SELECT SUM(InvoiceTotal - CreditTotal - PaymentTotal)
           FROM @OutTable) >= @HowMuch
        UPDATE @OutTable
        SET CreditTotal = CreditTotal + .01
        WHERE (InvoiceTotal - CreditTotal - PaymentTotal) > 0;
    RETURN;
END;
