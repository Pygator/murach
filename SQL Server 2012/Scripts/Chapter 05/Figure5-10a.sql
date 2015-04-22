USE AP;

SELECT InvoiceNumber, InvoiceDate, InvoiceTotal,
    SUM(InvoiceTotal) OVER (PARTITION BY InvoiceDate) AS DateTotal,
    COUNT(InvoiceTotal) OVER (PARTITION BY InvoiceDate) AS DateCount,
    AVG(InvoiceTotal) OVER (PARTITION BY InvoiceDate) AS DateAvg
FROM Invoices;
