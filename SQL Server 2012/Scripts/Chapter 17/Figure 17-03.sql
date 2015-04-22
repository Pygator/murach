USE AP;

BEGIN TRAN;
PRINT 'First Tran  @@TRANCOUNT: ' + CONVERT(varchar,@@TRANCOUNT);
DELETE Invoices;
  BEGIN TRAN;
    PRINT 'Second Tran @@TRANCOUNT: ' + CONVERT(varchar,@@TRANCOUNT);
    DELETE Vendors;
  COMMIT TRAN;          -- This COMMIT decrements @@TRANCOUNT.
                         -- It doesn't commit 'DELETE Vendors'.
  PRINT 'COMMIT     @@TRANCOUNT: ' + CONVERT(varchar,@@TRANCOUNT);
ROLLBACK TRAN;
PRINT 'ROLLBACK   @@TRANCOUNT: ' + CONVERT(varchar,@@TRANCOUNT);

PRINT ' ';
DECLARE @VendorsCount int, @InvoicesCount int;
SELECT @VendorsCount = COUNT (*) FROM Vendors;
SELECT @InvoicesCount = COUNT (*) FROM Invoices;
PRINT 'Vendors Count:  ' + CONVERT (varchar , @VendorsCount);
PRINT 'Invoices Count: ' + CONVERT (varchar , @InvoicesCount);