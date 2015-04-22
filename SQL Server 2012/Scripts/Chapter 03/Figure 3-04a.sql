USE AP;

SELECT InvoiceNumber AS [Invoice Number], InvoiceDate AS Date,
    InvoiceTotal AS Total
FROM Invoices;

SELECT [Invoice Number] = InvoiceNumber, Date = InvoiceDate,
    Total = InvoiceTotal
FROM Invoices;

