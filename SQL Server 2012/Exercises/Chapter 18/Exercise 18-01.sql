USE AP;

CREATE ROLE PaymentEntry;

GRANT UPDATE
  ON Invoices
  TO PaymentEntry;

GRANT INSERT,UPDATE
  ON InvoiceLineItems
  TO PaymentEntry;

ALTER ROLE db_datareader ADD MEMBER PaymentEntry;
