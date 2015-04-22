USE AP;

SELECT 'Invoice: #' + InvoiceNumber
    + ', dated ' + CONVERT(char(8), PaymentDate, 1)
    + ' for $' + CONVERT(varchar(9), PaymentTotal, 1)
FROM Invoices;
