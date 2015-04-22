USE AP;

SELECT InvoiceNumber, InvoiceTotal, InvoiceDate, InvoiceDueDate,
    CASE
        WHEN DATEDIFF(day, InvoiceDueDate, GETDATE()) > 30
            THEN 'Over 30 days past due'
        WHEN DATEDIFF(day, InvoiceDueDate, GETDATE()) > 0
            THEN '1 to 30 days past due'
        ELSE 'Current'
    END AS Status
FROM Invoices
WHERE InvoiceTotal - PaymentTotal - CreditTotal > 0;
