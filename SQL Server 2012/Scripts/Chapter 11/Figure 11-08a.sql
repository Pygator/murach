USE New_AP;

CREATE TABLE Invoices3
(InvoiceID       INT   NOT NULL IDENTITY PRIMARY KEY,
InvoiceTotal     MONEY NOT NULL CHECK (InvoiceTotal > 0));
