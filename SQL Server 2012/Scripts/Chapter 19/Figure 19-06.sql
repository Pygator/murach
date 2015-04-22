USE AP;

SELECT 
    EventID, 
    EventData.value('(/EVENT_INSTANCE/EventType)[1]', 'varchar(40)') 
        AS EventType,
    EventData.value('(/EVENT_INSTANCE/PostTime)[1]', 'smalldatetime') 
        AS PostTime, 
    EventData.value('(/EVENT_INSTANCE/LoginName)[1]', 'varchar(40)') 
        AS LoginName, 
    EventData.value('(/EVENT_INSTANCE/ObjectName)[1]', 'varchar(40)') 
        AS ObjectName
FROM DDLActivityLog
WHERE 
    EventData.value('(/EVENT_INSTANCE/EventType)[1]', 'varchar(40)') 
        = 'DROP_TABLE';