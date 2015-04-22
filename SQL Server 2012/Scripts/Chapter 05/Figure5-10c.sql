USE AP;

SELECT InvoiceNumber, TermsID, InvoiceDate, InvoiceTotal,
    SUM(InvoiceTotal)
        OVER (PARTITION BY TermsID ORDER BY InvoiceDate) AS CumTotal,
    COUNT(InvoiceTotal)
        OVER (PARTITION BY TermsID ORDER BY InvoiceDate) AS Count,
    AVG(InvoiceTotal)
        OVER (PARTITION BY TermsID ORDER BY InvoiceDate) AS MovingAvg
FROM Invoices;
