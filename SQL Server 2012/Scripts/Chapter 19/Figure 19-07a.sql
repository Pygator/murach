USE AP;

CREATE TABLE DDLActivityLog2
(
    EventID int NOT NULL IDENTITY PRIMARY KEY,
    EventType varchar(40) NOT NULL, 
    PostTime smalldatetime NOT NULL, 
    LoginName varchar(40) NOT NULL, 
    ObjectName varchar(40) NOT NULL
);