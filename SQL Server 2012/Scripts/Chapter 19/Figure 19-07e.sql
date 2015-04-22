USE AP;
GO

IF  EXISTS 
	(SELECT * FROM sys.triggers 
	 WHERE name = 'Database_CreateTable_DropTable2' 
	 AND parent_class=0)
BEGIN
	DROP TRIGGER Database_CreateTable_DropTable2 ON DATABASE;
END;
GO

IF OBJECT_ID('DDLActivityLog2') IS NOT NULL
    DROP TABLE DDLActivityLog2;
