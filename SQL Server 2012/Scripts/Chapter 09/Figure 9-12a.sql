USE AP;

SELECT PaymentDate,
    COALESCE(PaymentDate, '1900-01-01') AS NewDate
FROM Invoices;
