USE AP;

SELECT InvoiceNumber, InvoiceDate, InvoiceTotal,
    SUM(InvoiceTotal) OVER (ORDER BY InvoiceDate) AS CumTotal,
    COUNT(InvoiceTotal) OVER (ORDER BY InvoiceDate) AS Count,
    AVG(InvoiceTotal) OVER (ORDER BY InvoiceDate) AS MovingAvg
FROM Invoices;
