USE AP;

SELECT sys.tables.name AS TableName, sys.schemas.name AS SchemaName
FROM sys.tables INNER JOIN sys.schemas
ON sys.tables.schema_id = sys.schemas.schema_id;
