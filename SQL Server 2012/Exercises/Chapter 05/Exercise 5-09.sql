USE AP;

SELECT VendorID, InvoiceDate, InvoiceTotal,
    SUM(InvoiceTotal) OVER (PARTITION BY VendorID) AS VendorTotal,
    COUNT(InvoiceTotal) OVER (PARTITION BY VendorID) AS VendorCount,
    AVG(InvoiceTotal) OVER (PARTITION BY VendorID) AS VendorAvg
FROM Invoices;
