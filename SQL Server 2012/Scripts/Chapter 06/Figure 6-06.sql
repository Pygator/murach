USE AP;

SELECT VendorName, InvoiceNumber, InvoiceTotal
FROM Vendors JOIN Invoices ON Vendors.VendorID = Invoices.VendorID
WHERE InvoiceTotal < ANY
    (SELECT InvoiceTotal
    FROM Invoices
    WHERE VendorID = 115);


