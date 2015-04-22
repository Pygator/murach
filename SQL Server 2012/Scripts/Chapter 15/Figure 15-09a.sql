USE AP;

-- drop stored procedure if it exists already
IF OBJECT_ID('spInsertLineItems') IS NOT NULL
    DROP PROC spInsertLineItems;
GO

-- drop table type if it exists already
IF  EXISTS (SELECT * FROM sys.types WHERE name = 'LineItems')
    DROP TYPE LineItems;
GO

-- create the user-defined table type named LineItems
CREATE TYPE LineItems AS
TABLE
(InvoiceID        INT           NOT NULL,
InvoiceSequence   SMALLINT      NOT NULL,
AccountNo         INT           NOT NULL,
ItemAmount        MONEY         NOT NULL,
ItemDescription   VARCHAR(100)  NOT NULL,
PRIMARY KEY (InvoiceID, InvoiceSequence));

GO

-- create a stored procedure that accepts the LineItems type
CREATE PROC spInsertLineItems
    @LineItems LineItems READONLY
AS
    INSERT INTO InvoiceLineItems
    SELECT *
    FROM @LineItems;

GO