USE AP;

SELECT TRY_CONVERT(varchar, InvoiceDate) AS varcharDate,
    TRY_CONVERT(varchar, InvoiceDate, 1) AS varcharDate_1,
    TRY_CONVERT(varchar, InvoiceDate, 107) AS varcharDate_107,
    TRY_CONVERT(varchar, InvoiceTotal) AS varcharTotal,
    TRY_CONVERT(varchar, InvoiceTotal, 1) AS varcharTotal_1,
    TRY_CONVERT(date, 'Feb 29 2011') AS invalidDate
FROM Invoices;
