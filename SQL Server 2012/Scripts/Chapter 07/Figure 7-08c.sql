USE AP;

DELETE InvoiceCopy
WHERE InvoiceTotal - PaymentTotal - CreditTotal = 0;
