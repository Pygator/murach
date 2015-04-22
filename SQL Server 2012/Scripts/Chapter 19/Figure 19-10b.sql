USE AP;

IF OBJECT_ID('DDLActivityLog3') IS NOT NULL
    DROP TABLE DDLActivityLog3;

IF  EXISTS 
	(SELECT * FROM sys.xml_schema_collections
	 WHERE name = 'EventDataSchema')
BEGIN
	DROP XML SCHEMA COLLECTION EventDataSchema;
END;