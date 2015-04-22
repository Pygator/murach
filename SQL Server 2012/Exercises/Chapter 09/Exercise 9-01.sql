USE AP;

SELECT VendorContactFName + ' ' +
         LEFT(VendorContactLName, 1) + '.' AS Contact,
       SUBSTRING(VendorPhone,7,8) AS Phone
--Also acceptable:
--     REPLACE(VendorPhone,'(559) ','') AS Phone
FROM Vendors
WHERE LEFT(VendorPhone,4) = '(559'
ORDER BY Contact;
