-- You may need to run the script stored in Figure 4-03c.sql
-- before this SELECT statement will execute successfully

USE AP;

SELECT VendorName, CustLastName, CustFirstName,
    VendorState AS State, VendorCity AS City
FROM DBServer.AP.dbo.Vendors AS Vendors
    JOIN DBServer.ProductOrders.dbo.Customers AS Customers
    ON Vendors.VendorZipCode = Customers.CustZip
ORDER BY State, City;

