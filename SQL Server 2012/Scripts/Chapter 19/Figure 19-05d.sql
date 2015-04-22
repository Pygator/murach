USE AP

DECLARE @EventData xml;

SELECT @EventData = EventData 
FROM DDLActivityLog
WHERE EventID = 1;

SET @EventData.modify
('replace value of (/EVENT_INSTANCE/EventType/text())[1] with "TEST"');

SELECT @EventData AS ModifiedEventData;