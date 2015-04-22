USE AP;
GO

CREATE VIEW TopVendors
AS
SELECT TOP 5 PERCENT VendorID, InvoiceTotal
FROM Invoices
ORDER BY InvoiceTotal DESC;
