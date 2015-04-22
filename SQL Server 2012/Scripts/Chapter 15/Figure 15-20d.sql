USE AP;
/*
This script fixes the data error caused by
Figure 14-20a.sql by returning the value in the
InvoiceLineItems table to its original, correct,
value for InvoiceID 98.
*/

UPDATE InvoiceLineItems
SET InvoiceLineItemAmount = 579.42
WHERE InvoiceID = 98 AND InvoiceSequence = 1;