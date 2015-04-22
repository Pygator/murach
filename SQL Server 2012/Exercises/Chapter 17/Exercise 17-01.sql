USE AP;

-- NOTE: You may need to drop the trigger 
-- that you created in the exercises for chapter 15 
-- before this solution will run correctly, like this:
IF  EXISTS (SELECT * FROM sys.triggers 
            WHERE object_id = OBJECT_ID('Invoices_UPDATE_Shipping'))
	DROP TRIGGER [dbo].[Invoices_UPDATE_Shipping];
GO

-- the solution:
BEGIN TRAN;
  UPDATE Invoices
  SET VendorID = 123
  WHERE VendorID = 122;

  DELETE Vendors
  WHERE VendorID = 122;

  UPDATE Vendors
  SET VendorName = 'FedUP'
  WHERE VendorID = 123;
COMMIT TRAN;
