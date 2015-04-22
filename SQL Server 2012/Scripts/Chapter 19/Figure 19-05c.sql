USE AP;

SELECT 
    EventData.value(
        '(/EVENT_INSTANCE/EventType)[1]', 
        'varchar(40)') AS EventType,
    EventData.value(
        '(/EVENT_INSTANCE/TSQLCommand/SetOptions/@ANSI_NULLS)[1]', 
        'varchar(40)') AS ANSI_NULLS_SETTING
FROM DDLActivityLog
WHERE EventID = 1;