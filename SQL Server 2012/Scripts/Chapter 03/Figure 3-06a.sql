USE AP;

SELECT InvoiceTotal, PaymentTotal, CreditTotal,
    InvoiceTotal - PaymentTotal - CreditTotal AS BalanceDue
FROM Invoices;
