USE AP;

SELECT InvoiceNumber, InvoiceDate, InvoiceTotal
FROM Invoices
WHERE InvoiceDate BETWEEN '2012-01-01' AND '2012-05-31'
ORDER BY InvoiceDate;

