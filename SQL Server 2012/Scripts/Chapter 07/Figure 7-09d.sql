USE AP;

DELETE VendorCopy
FROM VendorCopy JOIN 
       (SELECT VendorID, SUM(InvoiceTotal) AS TotalOfInvoices
        FROM InvoiceCopy
        GROUP BY VendorID) AS InvoiceSum
    ON VendorCopy.VendorID = InvoiceSum.VendorID
WHERE TotalOfInvoices <= 100;
