USE AP;

SELECT EventData.query('/EVENT_INSTANCE/TSQLCommand/SetOptions')
    AS SetOptions
FROM DDLActivityLog
WHERE EventID = 1;