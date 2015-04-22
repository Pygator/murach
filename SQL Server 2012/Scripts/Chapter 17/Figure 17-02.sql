USE AP;

BEGIN TRAN;

DELETE Invoices
WHERE VendorID = 34;

IF @@ROWCOUNT > 1
    BEGIN
        ROLLBACK TRAN;
        PRINT 'More invoices than expected. Deletions rolled back.';
    END;
ELSE
    BEGIN
        COMMIT TRAN;
        PRINT 'Deletions committed to the database.';
    END;