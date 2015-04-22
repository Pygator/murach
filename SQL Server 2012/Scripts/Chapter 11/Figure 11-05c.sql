USE AP;

-- Drop the filtered index if it already exists
IF  EXISTS (SELECT * FROM sys.indexes 
            WHERE object_id = OBJECT_ID('Invoices') 
            AND name = 'IX_InvoicesPaymentFilter')
    DROP INDEX IX_InvoicesPaymentFilter ON Invoices;
GO

-- Create a filtered index
CREATE INDEX IX_InvoicesPaymentFilter
    ON Invoices (InvoiceDate DESC, InvoiceTotal)
WHERE PaymentDate IS NULL;

-- Use the filtered index
SELECT InvoiceID, InvoiceTotal, InvoiceDate
FROM Invoices
WHERE PaymentDate IS NULL;

