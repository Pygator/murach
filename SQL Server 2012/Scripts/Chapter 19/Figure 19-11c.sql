USE AP;

SELECT TOP 5 VendorName, InvoiceNumber, InvoiceTotal
FROM Vendors AS Vendor JOIN Invoices AS Invoice
    ON Vendor.VendorID = Invoice.VendorID
ORDER BY VendorName
FOR XML AUTO, ROOT ('VendorInvoices'), ELEMENTS;
