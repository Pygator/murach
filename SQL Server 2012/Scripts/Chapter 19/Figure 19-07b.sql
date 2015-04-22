USE AP;
GO

CREATE TRIGGER Database_CreateTable_DropTable2
    ON DATABASE
    AFTER CREATE_TABLE, DROP_TABLE
AS
    DECLARE @EventData XML;
    SELECT @EventData = EVENTDATA();
    INSERT INTO DDLActivityLog2 VALUES
    (
        @EventData.value('(/EVENT_INSTANCE/EventType)[1]', 'varchar(40)'),
        @EventData.value('(/EVENT_INSTANCE/PostTime)[1]', 'varchar(40)'), 
        @EventData.value('(/EVENT_INSTANCE/LoginName)[1]', 'varchar(40)'), 
        @EventData.value('(/EVENT_INSTANCE/ObjectName)[1]', 'varchar(40)')
    );