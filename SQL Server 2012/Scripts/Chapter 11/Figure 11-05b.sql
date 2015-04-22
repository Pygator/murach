USE New_AP;

CREATE INDEX IX_Invoices
    ON Invoices (InvoiceDate DESC, InvoiceTotal);
