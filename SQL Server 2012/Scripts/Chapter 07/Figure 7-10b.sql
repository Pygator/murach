USE AP;

-- STEP 1: run the script in figure 7-10a
-- it should merge all rows in the InvoiceCopy table
-- into the InvoiceArchive table

-- STEP 2: run this script

-- insert a row
INSERT INTO InvoiceCopy
VALUES (3, 'P29381', '2012-08-01', 50.20, 0, 0, 1, '2012-08-31', NULL);

-- update a row
UPDATE InvoiceCopy
SET PaymentDate = '2012-05-21', 
    PaymentTotal = 579.42
WHERE InvoiceID = 114;

-- STEP 3: run the script in figure 7-10a again
-- it should only insert and update the two rows shown in this script;
