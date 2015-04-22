USE AP;

SELECT InvoiceNumber, InvoiceDate, InvoiceTotal
FROM Invoices
WHERE VendorID IN
    (SELECT VendorID
    FROM Vendors
    WHERE VendorState = 'CA')
ORDER BY InvoiceDate;
