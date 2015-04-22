USE AP;
GO

CREATE TRIGGER Database_CreateTable_DropTable
    ON DATABASE
    AFTER CREATE_TABLE, DROP_TABLE
AS
    DECLARE @EventData xml;
    SELECT @EventData = EVENTDATA();

    DECLARE @EventType varchar(100);
    SET @EventType = 
        @EventData.value('(/EVENT_INSTANCE/EventType)[1]', 'varchar(100)');

    IF @EventType = 'CREATE_TABLE'
        PRINT 'A new table has been created.';
    ELSE
        PRINT 'A table has been dropped.';

    PRINT CONVERT(varchar(max), @EventData);