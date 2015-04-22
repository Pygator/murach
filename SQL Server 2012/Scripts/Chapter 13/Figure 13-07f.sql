USE AP;

IF OBJECT_ID('VendorPayment') IS NOT NULL
    DROP VIEW VendorPayment;
GO

CREATE VIEW VendorPayment
AS
SELECT VendorName, InvoiceNumber, InvoiceDate, PaymentDate,
    InvoiceTotal, CreditTotal, PaymentTotal
FROM Invoices JOIN Vendors ON Invoices.VendorID = Vendors.VendorID
WHERE InvoiceTotal - PaymentTotal - CreditTotal > 0
WITH CHECK OPTION;