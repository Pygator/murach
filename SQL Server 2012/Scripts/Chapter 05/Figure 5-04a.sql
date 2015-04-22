USE AP;

SELECT VendorID, COUNT(*) AS InvoiceQty
FROM Invoices
GROUP BY VendorID;
