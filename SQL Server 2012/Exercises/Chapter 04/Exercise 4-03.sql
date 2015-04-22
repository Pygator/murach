USE AP;

SELECT VendorName, DefaultAccountNo, AccountDescription
FROM Vendors JOIN GLAccounts
  ON Vendors.DefaultAccountNo = GLAccounts.AccountNo
ORDER BY AccountDescription, VendorName;
