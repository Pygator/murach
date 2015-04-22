USE AP;

-- delete old line item data
DELETE FROM InvoiceLineItems WHERE InvoiceID = 114;

-- declare a variable for the LineItems type
DECLARE @LineItems LineItems;

-- insert rows into the LineItems variable
INSERT INTO @LineItems VALUES (114, 1, 553, 127.75, 'Freight');
INSERT INTO @LineItems VALUES (114, 2, 553, 29.25, 'Freight');
INSERT INTO @LineItems VALUES (114, 3, 553, 48.50, 'Freight');

-- execute the stored procedure
EXEC spInsertLineItems @LineItems;