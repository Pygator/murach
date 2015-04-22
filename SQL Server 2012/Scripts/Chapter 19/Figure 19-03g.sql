USE AP;
GO

-- drop all objects used by figure 19-03

-- drop the trigger
IF  EXISTS 
	(SELECT * FROM sys.triggers 
	 WHERE name = 'Database_CreateTable_DropTable' 
	 AND parent_class=0)
BEGIN
	DROP TRIGGER Database_CreateTable_DropTable ON DATABASE;
END;
GO

-- drop both tables
IF OBJECT_ID('DDLActivityLog') IS NOT NULL
    DROP TABLE DDLActivityLog;

IF OBJECT_ID('VendorsTest') IS NOT NULL
    DROP TABLE VendorsTest;
