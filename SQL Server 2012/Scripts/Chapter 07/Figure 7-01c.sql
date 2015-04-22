USE AP;

SELECT VendorID, SUM(InvoiceTotal) AS SumOfInvoices
INTO VendorBalances
FROM Invoices
WHERE InvoiceTotal - PaymentTotal - CreditTotal <> 0
GROUP BY VendorID;
