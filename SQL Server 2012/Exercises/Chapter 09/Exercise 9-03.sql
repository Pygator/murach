USE AP;

SELECT InvoiceNumber,
       InvoiceTotal - CreditTotal - PaymentTotal AS Balance
FROM Invoices
WHERE InvoiceTotal - CreditTotal - PaymentTotal > 0 AND
      InvoiceDueDate <
 CAST(CAST(YEAR(GETDATE()) AS char(4)) + '-' +
      CAST(MONTH(GETDATE()) + 1 AS char(2)) + '-01' AS datetime) - 1;
