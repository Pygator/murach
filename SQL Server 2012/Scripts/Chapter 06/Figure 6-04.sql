USE AP;

SELECT InvoiceNumber, InvoiceDate, InvoiceTotal,
    InvoiceTotal - PaymentTotal - CreditTotal AS BalanceDue
FROM Invoices
WHERE InvoiceTotal - PaymentTotal - CreditTotal  > 0 
    AND InvoiceTotal - PaymentTotal - CreditTotal <
    (SELECT AVG(InvoiceTotal - PaymentTotal - CreditTotal)
    FROM Invoices
    WHERE InvoiceTotal - PaymentTotal - CreditTotal > 0)
ORDER BY InvoiceTotal DESC;

