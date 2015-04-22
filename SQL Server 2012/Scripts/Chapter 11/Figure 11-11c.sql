USE New_AP;

ALTER TABLE Invoices WITH NOCHECK
ADD CHECK (InvoiceTotal >= 1);
