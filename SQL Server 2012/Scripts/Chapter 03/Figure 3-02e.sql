USE AP;

SELECT InvoiceNumber, InvoiceDate, InvoiceTotal 
FROM Invoices
WHERE InvoiceTotal > 50000;

