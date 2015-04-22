CREATE VIEW Top10PaidInvoices
AS
SELECT TOP 10 VendorName,
       MAX(InvoiceDate) AS LastInvoice,
       SUM(InvoiceTotal) AS SumOfInvoices
FROM  Vendors JOIN Invoices
  ON Vendors.VendorID = Invoices.VendorID
WHERE InvoiceTotal - CreditTotal - PaymentTotal = 0
GROUP BY VendorName
ORDER BY SUM(InvoiceTotal) DESC;
