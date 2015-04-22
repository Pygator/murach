USE AP;

UPDATE InvoiceCredit
SET CreditTotal = CreditTotal + 200
WHERE InvoiceTotal - PaymentTotal - CreditTotal >= 200;
