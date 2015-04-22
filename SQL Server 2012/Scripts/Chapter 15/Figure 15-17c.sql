USE AP;

SELECT * FROM Vendors WHERE VendorID = (SELECT MAX(VendorID) FROM Vendors); 