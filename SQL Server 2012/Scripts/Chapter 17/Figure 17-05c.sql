USE AP;

BEGIN TRAN;
DECLARE @InvoiceTotal money, @PaymentTotal money, @CreditTotal money;
SELECT @InvoiceTotal = InvoiceTotal, @CreditTotal = CreditTotal,
       @PaymentTotal = PaymentTotal FROM Invoices WHERE InvoiceID = 112;
UPDATE Invoices
  SET InvoiceTotal = @InvoiceTotal, CreditTotal = @CreditTotal,
      PaymentTotal = @InvoiceTotal - @CreditTotal,
      PaymentDate = GetDate() WHERE InvoiceID = 112;
COMMIT TRAN;

-- The values after transaction A
SELECT InvoiceTotal, CreditTotal, PaymentTotal, PaymentDate
FROM Invoices WHERE InvoiceID = 112;
