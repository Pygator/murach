USE AP;

SELECT InvoiceNumber, InvoiceDate, InvoiceTotal,
    CHOOSE(TermsID, '10 days', '20 days', '30 days', '60 days', '90 days')
        AS NetDue
FROM Invoices
WHERE InvoiceTotal - PaymentTotal - CreditTotal > 0;
