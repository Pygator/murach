/*
Creates and queries a table, #TableSummary, that lists
the columns for each user table in the database, plus
the number of rows in each table.

Author:   Bryan Syverson
Created:  2006-07-02
Modified: 2008-07-16
*/

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
    WHERE name NOT IN ('dtproperties', 'TableSummary', 'AllUserTables'));

IF OBJECT_ID('tempdb..#AllUserTables') IS NOT NULL
    DROP TABLE #AllUserTables;

CREATE TABLE #AllUserTables
(TableID int IDENTITY, TableName varchar(128));
GO

INSERT #AllUserTables (TableName)
SELECT name
FROM sys.tables
WHERE name NOT IN ('dtproperties', 'TableSummary', 'AllUserTables');

DECLARE @LoopMax int, @LoopVar int;
DECLARE @TableNameVar varchar(128), @ExecVar varchar(1000);

SELECT @LoopMax = MAX(TableID) FROM #AllUserTables;

SET @LoopVar = 1;

WHILE @LoopVar <= @LoopMax
    BEGIN
        SELECT @TableNameVar = TableName 
            FROM #AllUserTables
            WHERE TableID = @LoopVar;
        SET @ExecVar = 'DECLARE @CountVar int; ';
        SET @ExecVar = @ExecVar + 'SELECT @CountVar = COUNT(*) ';
        SET @ExecVar = @ExecVar + 'FROM ' + @TableNameVar + '; ';
        SET @ExecVar = @ExecVar + 'INSERT #TableSummary ';
        SET @ExecVar = @ExecVar + 'VALUES (''' + @TableNameVar + ''',';
        SET @ExecVar = @ExecVar + '''*Row Count*'',';
        SET @ExecVar = @ExecVar + ' @CountVar);';
        EXEC (@ExecVar);
        SET @LoopVar = @LoopVar + 1;
    END;

SELECT * FROM #TableSummary
ORDER BY TableName, ColumnName;