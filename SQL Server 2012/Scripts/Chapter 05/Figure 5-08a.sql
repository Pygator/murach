USE AP;

SELECT VendorID, COUNT(*) AS InvoiceCount,
    SUM(InvoiceTotal) AS InvoiceTotal
FROM Invoices
-- GROUP BY CUBE(VendorID) -- 2008 and later
GROUP BY VendorID WITH CUBE;