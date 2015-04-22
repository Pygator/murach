USE AP;

DROP TABLE InvoiceCopy;
DROP TABLE VendorCopy;

SELECT *
INTO InvoiceCopy
FROM Invoices;

SELECT *
INTO VendorCopy
FROM Vendors;