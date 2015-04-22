USE AP;
GO

CREATE TRIGGER Database_CreateTable_DropTable
    ON DATABASE
    AFTER CREATE_TABLE, DROP_TABLE
AS
    DECLARE @EventData xml;
    SELECT @EventData = EVENTDATA();
    INSERT INTO DDLActivityLog VALUES (@EventData);