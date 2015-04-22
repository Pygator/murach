USE New_AP;

CREATE TABLE InvoiceLineItems1
(InvoiceID                 INT          NOT NULL,
InvoiceSequence            SMALLINT     NOT NULL,
InvoiceLineItemAmount      MONEY        NOT NULL,
PRIMARY KEY (InvoiceID, InvoiceSequence));
