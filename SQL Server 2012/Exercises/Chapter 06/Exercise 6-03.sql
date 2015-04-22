USE AP;

SELECT InvoiceNumber, InvoiceTotal
FROM Invoices
WHERE PaymentTotal > ALL
     (SELECT TOP 50 PERCENT PaymentTotal
      FROM Invoices
      WHERE PaymentTotal <> 0
      ORDER BY PaymentTotal);
