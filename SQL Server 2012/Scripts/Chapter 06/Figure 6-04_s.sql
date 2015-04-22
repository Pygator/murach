USE AP;

-- The subquery
SELECT AVG(InvoiceTotal - PaymentTotal - CreditTotal)
FROM Invoices
WHERE InvoiceTotal - PaymentTotal - CreditTotal > 0;
