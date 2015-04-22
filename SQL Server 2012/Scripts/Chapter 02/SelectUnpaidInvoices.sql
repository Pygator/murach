SELECT InvoiceNumber, InvoiceDate, InvoiceTotal, PaymentTotal, CreditTotal, 
       InvoiceTotal - PaymentTotal - CreditTotal AS BalanceDue
FROM Invoices
WHERE InvoiceTotal - PaymentTotal - CreditTotal  > 0
ORDER BY InvoiceDate;