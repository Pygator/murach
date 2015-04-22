USE AP;

SELECT PaymentDate,
    ISNULL(PaymentDate, '1900-01-01') AS NewDate
FROM Invoices;
