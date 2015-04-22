ALTER TABLE Invoices
ADD CHECK ((PaymentDate IS NULL     AND PaymentTotal = 0) OR
           (PaymentDate IS NOT NULL AND PaymentTotal > 0)),
    CHECK ((PaymentTotal + CreditTotal) <= InvoiceTotal);
