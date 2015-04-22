CREATE VIEW InvoiceBasic
AS
SELECT VendorName, InvoiceNumber, InvoiceTotal
FROM  Vendors JOIN Invoices
  ON Vendors.VendorID = Invoices.VendorID;
