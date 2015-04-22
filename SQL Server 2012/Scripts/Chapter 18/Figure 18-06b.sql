USE AP;
GO

CREATE SCHEMA Marketing
    CREATE TABLE Contacts
    (ContactID   INT         NOT NULL IDENTITY PRIMARY KEY,
    ContactName  VARCHAR(50) NOT NULL,
    ContactPhone VARCHAR(50) NULL,
    ContactEmail VARCHAR(50) NULL);