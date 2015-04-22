USE AP;

CREATE TABLE DDLActivityLog3
(EventID int NOT NULL IDENTITY PRIMARY KEY,
EventData xml (EventDataSchema) NOT NULL);