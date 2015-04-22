DECLARE @TableName varchar(128);

SELECT @TableName = MIN(name)
FROM sys.tables
WHERE name <> 'dtproperties' AND name <> 'sysdiagrams';

EXEC ('SELECT COUNT(*) AS CountOf' + @TableName +
      ' FROM ' + @TableName + ';');
