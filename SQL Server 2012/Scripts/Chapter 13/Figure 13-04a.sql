USE AP;
GO

CREATE VIEW VendorInvoices
AS
SELECT VendorName, InvoiceNumber, InvoiceDate, InvoiceTotal 
FROM Vendors JOIN Invoices ON Vendors.VendorID = Invoices.VendorID;
