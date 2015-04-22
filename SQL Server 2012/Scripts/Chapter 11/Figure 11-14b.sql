USE master;

CREATE TABLE Invoices
(InvoiceID             INT           NOT NULL IDENTITY PRIMARY KEY,
VendorID               INT           NOT NULL 
                       REFERENCES Vendors(VendorID),
InvoiceNumber          VARCHAR(50)   NOT NULL,
InvoiceDate            SMALLDATETIME NOT NULL,
InvoiceTotal           MONEY         NOT NULL,
PaymentTotal           MONEY         NOT NULL DEFAULT 0,
CreditTotal            MONEY         NOT NULL DEFAULT 0,
TermsID                INT           NOT NULL
                       REFERENCES Terms(TermsID),
InvoiceDueDate         SMALLDATETIME NOT NULL,
PaymentDate            SMALLDATETIME NULL);

CREATE TABLE InvoiceLineItems
(InvoiceID             INT           NOT NULL
                       REFERENCES Invoices(InvoiceID),
InvoiceSequence        SMALLINT      NOT NULL,
AccountNo              INT           NOT NULL
                       REFERENCES GLAccounts(AccountNo),
InvoiceLineItemAmount  MONEY         NOT NULL,
InvoiceLineItemDescription VARCHAR(100) NOT NULL,
PRIMARY KEY (InvoiceID, InvoiceSequence));

CREATE INDEX IX_Invoices_VendorID
    ON Invoices (VendorID);
CREATE INDEX IX_Invoices_TermsID
    ON Invoices (TermsID);
CREATE INDEX IX_Vendors_TermsID
    ON Vendors (DefaultTermsID);
CREATE INDEX IX_Vendors_AccountNo
    ON Vendors (DefaultAccountNo);
CREATE INDEX IX_InvoiceLineItems_AccountNo
    ON InvoiceLineItems (AccountNo);
CREATE INDEX IX_VendorName
    ON Vendors (VendorName);
CREATE INDEX IX_InvoiceDate
    ON Invoices (InvoiceDate DESC);
