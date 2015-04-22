SELECT VendorName, InvoiceID, InvoiceTotal
FROM Vendors JOIN Invoices
ON Vendors.VendorID = Invoices.VendorID
WHERE InvoiceID = dbo.GetLargestInvoice();