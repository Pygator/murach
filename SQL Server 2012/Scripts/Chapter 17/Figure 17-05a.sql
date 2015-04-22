USE AP;

-- Set the values for the row to their intitial values
UPDATE Invoices
SET InvoiceTotal = 10976.06, 
    CreditTotal = 0,
    PaymentTotal = 0, 
    PaymentDate = NULL
WHERE InvoiceID = 112;


-- The initial values for the row
SELECT InvoiceTotal, CreditTotal, PaymentTotal, PaymentDate
FROM Invoices WHERE InvoiceID = 112;