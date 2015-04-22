USE New_AP;

CREATE TABLE Invoices1
(InvoiceID       INT   NOT NULL IDENTITY PRIMARY KEY,
InvoiceTotal     MONEY NOT NULL CHECK (InvoiceTotal >= 0),
PaymentTotal     MONEY NOT NULL DEFAULT 0 CHECK (PaymentTotal >= 0));
