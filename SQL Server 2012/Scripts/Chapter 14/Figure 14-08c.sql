USE AP;

IF EXISTS (SELECT * FROM sys.tables
        WHERE name = 'InvoiceCopy')
    DROP TABLE InvoiceCopy;
