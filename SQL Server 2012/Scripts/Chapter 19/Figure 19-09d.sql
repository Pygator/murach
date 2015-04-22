USE AP;

DECLARE @CreateTableEvent xml (EventDataSchema);
SET @CreateTableEvent = '
<EVENT_INSTANCE>
  <EventType>CREATE_TABLE</EventType>
</EVENT_INSTANCE>
';
INSERT INTO DDLActivityLog3 
VALUES (@CreateTableEvent);