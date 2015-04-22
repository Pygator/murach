USE AP;

SELECT VendorName,
    COALESCE(CAST(InvoiceTotal AS varchar), 'No invoices') AS InvoiceTotal
FROM Vendors LEFT JOIN Invoices
    ON Vendors.VendorID = Invoices.VendorID
ORDER BY VendorName;
