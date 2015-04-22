USE AP;

UPDATE InvoiceCopy
SET PaymentDate = GETDATE(),
    PaymentTotal = InvoiceTotal - CreditTotal
WHERE InvoiceTotal - CreditTotal - PaymentTotal > 0;
