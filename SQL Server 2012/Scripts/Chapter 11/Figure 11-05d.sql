USE AP;

-- Drop the filtered index if it already exists
IF  EXISTS (SELECT * FROM sys.indexes 
            WHERE object_id = OBJECT_ID('Invoices') 
            AND name = 'IX_InvoicesDateFilter')
    DROP INDEX IX_InvoicesDateFilter ON Invoices;
GO

-- Create a filtered index
CREATE INDEX IX_InvoicesDateFilter
    ON Invoices (InvoiceDate DESC, InvoiceTotal)
WHERE InvoiceDate > '2012-02-01';

-- Use the filtered index
SELECT InvoiceID, InvoiceTotal, InvoiceDate
FROM Invoices
WHERE InvoiceDate > '2012-03-01';

