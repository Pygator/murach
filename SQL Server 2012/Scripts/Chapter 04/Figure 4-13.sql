-- The following statements are only needed if
-- the ActiveInvoices and PaidInvoices tables
-- haven't already been created
/*
USE AP;

SELECT *
INTO Examples..ActiveInvoices
FROM Invoices
WHERE InvoiceTotal - PaymentTotal - CreditTotal > 0;

SELECT *
INTO Examples..PaidInvoices
FROM Invoices
WHERE InvoiceTotal - PaymentTotal - CreditTotal <= 0;
*/

USE Examples;

    SELECT 'Active' AS Source, InvoiceNumber, InvoiceDate, InvoiceTotal
    FROM ActiveInvoices
    WHERE InvoiceDate >= '02/01/2012'
UNION
    SELECT 'Paid' AS Source, InvoiceNumber, InvoiceDate, InvoiceTotal
    FROM PaidInvoices
    WHERE InvoiceDate >= '02/01/2012'
ORDER BY InvoiceTotal DESC;

