USE AP;

SELECT VendorID, COUNT(*) AS InvoiceCount,
    SUM(InvoiceTotal) AS InvoiceTotal
FROM Invoices
GROUP BY VendorID WITH ROLLUP;

-- GROUP BY ROLLUP(VendorID) -- 2008 and later
