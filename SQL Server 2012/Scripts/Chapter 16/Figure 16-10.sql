USE AP;
IF OBJECT_ID('tempdb..#TableSummary') IS NOT NULL
    DROP TABLE #TableSummary;
SELECT sys.tables.name AS TableName, sys.columns.name AS ColumnName,
    sys.types.name AS Type 
INTO #TableSummary
FROM sys.tables
    JOIN sys.columns ON sys.tables.object_id = sys.columns.object_id
    JOIN sys.types ON sys.columns.system_type_id = sys.types.system_type_id
WHERE sys.tables.name IN 
    (SELECT name 
    FROM sys.tables
    WHERE name NOT IN ('dtproperties', 'TableSummary'));

DECLARE @TableNameVar varchar(128), @ExecVar varchar(1000);
DECLARE TableSummary_Cursor CURSOR
FAST_FORWARD
FOR
    SELECT DISTINCT TableName
    FROM #TableSummary;

OPEN TableSummary_Cursor;
FETCH NEXT FROM TableSummary_Cursor INTO @TableNameVar;
WHILE @@FETCH_STATUS = 0
BEGIN
    SET @ExecVar = 'DECLARE @CountVar int ' + 'SELECT @CountVar = COUNT(*) ';
    SET @ExecVar = @ExecVar + 'FROM ' + @TableNameVar + ' ';
    SET @ExecVar = @ExecVar + 'INSERT #TableSummary ';
    SET @ExecVar = @ExecVar + 'VALUES (''' + @TableNameVar + ''',';
    SET @ExecVar = @ExecVar + '''*Row Count*'',' + ' @CountVar)';
    EXEC (@ExecVar);
    FETCH NEXT FROM TableSummary_Cursor INTO @TableNameVar;
END;
CLOSE TableSummary_Cursor;
DEALLOCATE TableSummary_Cursor;

SELECT * FROM #TableSummary
ORDER BY TableName, ColumnName;