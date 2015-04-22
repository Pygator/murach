USE AP;

SELECT InvoiceDate, InvoiceTotal,
    CAST(InvoiceDate AS varchar) AS varcharDate,
    CAST(InvoiceTotal AS integer) AS integerTotal,
    CAST(InvoiceTotal AS varchar) AS varcharTotal
FROM Invoices;
