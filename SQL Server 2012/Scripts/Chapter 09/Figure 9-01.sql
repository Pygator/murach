USE AP;

Select VendorName, VendorContactLName + ', ' + LEFT(VendorContactFName, 1)
       + '.' AS ContactName, RIGHT(VendorPhone, 8) AS Phone
FROM Vendors
WHERE SUBSTRING(VendorPhone, 2, 3) = 559
ORDER BY VendorName;

