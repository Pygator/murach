USE AP;

SELECT *
FROM Vendors JOIN Invoices
  ON Vendors.VendorID = Invoices.VendorID;
