USE AP;

SELECT VendorState, VendorCity, COUNT(*) AS InvoiceQty,
    AVG(InvoiceTotal) AS InvoiceAvg
FROM Invoices JOIN Vendors
    ON Invoices.VendorID = Vendors.VendorID
GROUP BY VendorState, VendorCity
ORDER BY VendorState, VendorCity;

