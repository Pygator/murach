USE AP;

SELECT InvoiceID,
    InvoiceID + 7 * 3 AS OrderOfPrecedence,
    (InvoiceID + 7) * 3 AS AddFirst
FROM Invoices
ORDER BY InvoiceID;
