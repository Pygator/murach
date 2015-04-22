USE AP;

DECLARE @BigVendors table
(VendorID int,
VendorName varchar(50));

INSERT @BigVendors
SELECT VendorID, VendorName
FROM Vendors
WHERE VendorID IN (SELECT VendorID FROM Invoices WHERE InvoiceTotal > 5000);

SELECT * FROM @BigVendors;