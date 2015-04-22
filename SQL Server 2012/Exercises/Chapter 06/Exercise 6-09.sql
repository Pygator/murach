USE AP;

WITH MaxInvoice AS
(
    SELECT VendorID, MAX(InvoiceTotal) AS InvoiceMax
    FROM Invoices
    WHERE InvoiceTotal - CreditTotal - PaymentTotal > 0
    GROUP BY VendorID
)
SELECT SUM(InvoiceMax) AS SumOfMaximums
FROM MaxInvoice;