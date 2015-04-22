USE New_AP;

CREATE TABLE Invoices9
(InvoiceID       INT NOT NULL PRIMARY KEY,
VendorID         INT NOT NULL REFERENCES Vendors9 (VendorID),
InvoiceTotal     MONEY NULL);
