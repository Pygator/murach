USE AP;

UPDATE InvoiceCopy
SET CreditTotal = CreditTotal + 100
FROM
   (SELECT TOP 10 InvoiceID
    FROM InvoiceCopy
    WHERE InvoiceTotal - PaymentTotal - CreditTotal >= 100
    ORDER BY InvoiceTotal - PaymentTotal - CreditTotal DESC) AS TopInvoices
WHERE InvoiceCopy.InvoiceID = TopInvoices.InvoiceID;
