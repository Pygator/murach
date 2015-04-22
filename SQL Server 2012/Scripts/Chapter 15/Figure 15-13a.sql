USE AP;

IF OBJECT_ID('fnBalanceDue') IS NOT NULL
    DROP FUNCTION fnBalanceDue;
GO

CREATE FUNCTION fnBalanceDue()
    RETURNS money
BEGIN
    RETURN (SELECT SUM(InvoiceTotal - PaymentTotal - CreditTotal)
            FROM Invoices
            WHERE InvoiceTotal - PaymentTotal - CreditTotal > 0);
END;
