USE AP;

SELECT *
INTO OldInvoices
FROM Invoices
WHERE InvoiceTotal - PaymentTotal - CreditTotal = 0;
