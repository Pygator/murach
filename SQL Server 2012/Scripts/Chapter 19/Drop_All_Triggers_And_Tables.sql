USE AP;
GO

-- drop all objects used by chapter 18

-- drop both triggers
IF  EXISTS 
	(SELECT * FROM sys.triggers 
	 WHERE name = 'Database_CreateTable_DropTable' 
	 AND parent_class=0)
BEGIN
	DROP TRIGGER Database_CreateTable_DropTable ON DATABASE;
END;
GO

IF  EXISTS 
	(SELECT * FROM sys.triggers 
	 WHERE name = 'Database_CreateTable_DropTable2' 
	 AND parent_class=0)
BEGIN
	DROP TRIGGER Database_CreateTable_DropTable2 ON DATABASE;
END;
GO

-- drop all DDLActivity tables

IF OBJECT_ID('DDLActivityLog') IS NOT NULL
    DROP TABLE DDLActivityLog;

IF OBJECT_ID('DDLActivityLog2') IS NOT NULL
    DROP TABLE DDLActivityLog2;

IF OBJECT_ID('DDLActivityLog3') IS NOT NULL
    DROP TABLE DDLActivityLog3;

-- drop the VendorsTest table

IF OBJECT_ID('VendorsTest') IS NOT NULL
    DROP TABLE VendorsTest;
