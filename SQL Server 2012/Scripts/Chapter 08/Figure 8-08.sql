USE AP;

SELECT CONVERT(varchar, InvoiceDate) AS varcharDate,
    CONVERT(varchar, InvoiceDate, 1) AS varcharDate_1,
    CONVERT(varchar, InvoiceDate, 107) AS varcharDate_107,
    CONVERT(varchar, InvoiceTotal) AS varcharTotal,
    CONVERT(varchar, InvoiceTotal, 1) AS varcharTotal_1
FROM Invoices;
