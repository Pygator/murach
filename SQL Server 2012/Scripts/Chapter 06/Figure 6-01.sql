USE AP;

SELECT InvoiceNumber, InvoiceDate, InvoiceTotal
FROM Invoices
WHERE InvoiceTotal > 
    (SELECT AVG(InvoiceTotal)
     FROM Invoices)
ORDER BY InvoiceTotal;

