USE AP;

SELECT InvoiceNumber,
    InvoiceTotal - CreditTotal - PaymentTotal AS Balance, 
    RANK() OVER (ORDER BY InvoiceTotal - CreditTotal - 
        PaymentTotal DESC) As BalanceRank
FROM Invoices
WHERE InvoiceTotal - CreditTotal - PaymentTotal > 0 AND
    InvoiceDueDate < GETDATE() + 30;