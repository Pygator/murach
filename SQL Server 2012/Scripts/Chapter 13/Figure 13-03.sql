USE AP;
GO

CREATE VIEW VendorShortList
AS
SELECT VendorName, VendorContactLName, VendorContactFName, VendorPhone
FROM Vendors
WHERE VendorID IN (SELECT VendorID FROM Invoices);
