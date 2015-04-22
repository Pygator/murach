USE AP;

SELECT InvoiceID,
    InvoiceID / 10 AS Quotient,
    InvoiceID % 10 AS Remainder
FROM Invoices
ORDER BY InvoiceID;
