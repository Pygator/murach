USE AP;

IF OBJECT_ID('InvoiceSummary') IS NOT NULL
    DROP VIEW InvoiceSummary;
GO

CREATE VIEW InvoiceSummary
AS
SELECT VendorName, COUNT(*) AS InvoiceQty, SUM(InvoiceTotal) AS InvoiceSum
FROM Vendors JOIN Invoices ON Vendors.VendorID = Invoices.VendorID
GROUP BY VendorName;
