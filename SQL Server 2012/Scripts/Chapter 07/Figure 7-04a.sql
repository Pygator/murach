USE AP;

INSERT INTO InvoiceArchive
SELECT *
FROM InvoiceCopy
WHERE InvoiceTotal - PaymentTotal - CreditTotal = 0;
