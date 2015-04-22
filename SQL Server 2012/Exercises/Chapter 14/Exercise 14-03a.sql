USE AP;

IF OBJECT_ID('FirstInvoice_V') IS NOT NULL
    DROP VIEW FirstInvoice_V;
GO

CREATE VIEW FirstInvoice_V
AS
SELECT VendorID, MIN(InvoiceDate) AS FirstInvoiceDate
FROM Invoices
GROUP BY VendorID;
