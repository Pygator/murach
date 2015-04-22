USE AP;

DECLARE @EventData xml;

SELECT @EventData = EventData 
FROM DDLActivityLog
WHERE EventID = 1;

IF @EventData.exist('/EVENT_INSTANCE/EventType') = 1
    PRINT 'The EventType element exists and contains data.';