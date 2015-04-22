USE AP;
DECLARE @DynamicSQL varchar(8000);

IF OBJECT_ID('XtabVendors') IS NOT NULL
    DROP TABLE XtabVendors;

SET @DynamicSQL = 'CREATE TABLE XtabVendors ('
    SELECT @DynamicSQL = @DynamicSQL + '[' + VendorName + '] bit,'
    FROM Vendors 
    WHERE VendorID IN
        (SELECT VendorID 
        FROM Invoices 
        WHERE InvoiceTotal - CreditTotal - PaymentTotal > 0)
    ORDER BY VendorName;
SET @DynamicSQL = @DynamicSQL + ');';

EXEC (@DynamicSQL);

SELECT * FROM XtabVendors;