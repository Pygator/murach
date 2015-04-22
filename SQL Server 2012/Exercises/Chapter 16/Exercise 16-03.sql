USE AP;

DECLARE @TableName varchar(128);
DECLARE @DynamicSQL varchar(256);
DECLARE Schema_Cursor CURSOR
STATIC
FOR
    SELECT name
    FROM sys.tables
    WHERE name <> 'dtproperties' AND name <> 'sysdiagrams';
OPEN Schema_Cursor;
FETCH NEXT FROM Schema_Cursor INTO @TableName;
WHILE @@FETCH_STATUS = 0
  BEGIN
    SET @DynamicSQL = 'SELECT TOP 1 * FROM ' + @TableName;
    EXEC (@DynamicSQL);
    FETCH NEXT FROM Schema_Cursor INTO @TableName;
  END;

CLOSE Schema_Cursor;
DEALLOCATE Schema_Cursor;
