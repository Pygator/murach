USE New_AP;
/*
This script is not in the book, but must be
run before you try to run the last two examples 
in figure 11-11.
*/

CREATE TABLE InvoiceLineItems
(
InvoiceID                  INT          NOT NULL,
InvoiceSequence            SMALLINT     NOT NULL,
AccountNo                  INT          NOT NULL,
InvoiceLineItemAmount      MONEY        NOT NULL,
InvoiceLineItemDescription VARCHAR(100) NOT NULL,
PRIMARY KEY (InvoiceID, InvoiceSequence)
);

CREATE TABLE GLAccounts
(AccountNo         INT         NOT NULL PRIMARY KEY,
AccountDescription VARCHAR(50) NOT NULL);
