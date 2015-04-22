-- If the trigger named Database_CreateTable_DropTable already exists, 
-- use this script to drop it

USE AP;
GO

IF  EXISTS 
	(SELECT * FROM sys.triggers 
	 WHERE name = 'Vendors_Update_State' 
	 AND parent_class=0)
BEGIN
	DROP TRIGGER [Database_CreateTable_DropTable] ON DATABASE;
END;
GO

IF  EXISTS 
	(SELECT * FROM sys.triggers 
	 WHERE name = 'Database_CreateTable_DropTable' 
	 AND parent_class=0)
BEGIN
	DROP TRIGGER [Database_CreateTable_DropTable] ON DATABASE;
END;