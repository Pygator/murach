USE AP;

SELECT Number = InvoiceNumber,
       Total = InvoiceTotal,
       Credits = PaymentTotal + CreditTotal,
       Balance = InvoiceTotal - (PaymentTotal + CreditTotal)
FROM Invoices;
