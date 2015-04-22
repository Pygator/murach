USE AP;

SELECT InvoiceNumber, InvoiceDate, InvoiceTotal,
       InvoiceTotal - PaymentTotal - CreditTotal AS BalanceDue
FROM Invoices
WHERE InvoiceDate > '01/01/2012'
    OR InvoiceTotal > 500
    AND InvoiceTotal - PaymentTotal - CreditTotal > 0;
