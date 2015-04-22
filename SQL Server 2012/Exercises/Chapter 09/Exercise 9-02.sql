USE AP;

SELECT InvoiceNumber,
       InvoiceTotal - CreditTotal - PaymentTotal AS Balance
FROM Invoices
WHERE InvoiceTotal - CreditTotal - PaymentTotal > 0 AND
      InvoiceDueDate < GETDATE() + 30;