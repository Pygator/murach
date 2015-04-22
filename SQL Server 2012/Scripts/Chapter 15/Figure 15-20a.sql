USE AP;
/*
This script updates the InvoiceLineItems table 
to have an incorrect value for one of the line 
items for InvoiceID 100.
This is necessary to show how the trigger presented 
in figure 15-20 works.
*/

UPDATE InvoiceLineItems
SET InvoiceLineItemAmount = 477.79
WHERE InvoiceID = 98 AND InvoiceSequence = 1;
