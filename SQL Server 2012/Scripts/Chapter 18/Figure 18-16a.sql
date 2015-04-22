USE AP;

CREATE ROLE InvoiceEntry;

GRANT INSERT,UPDATE
ON Invoices
TO InvoiceEntry;

GRANT INSERT,UPDATE
ON InvoiceLineItems
TO InvoiceEntry;

ALTER ROLE InvoiceEntry ADD MEMBER JohnDoe;

ALTER ROLE db_datareader ADD MEMBER InvoiceEntry;