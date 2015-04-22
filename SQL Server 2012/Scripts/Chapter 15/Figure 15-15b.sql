USE AP;

SELECT VendorName, SUM(CreditTotal) AS CreditRequest
FROM Vendors JOIN dbo.fnCreditAdj(25000) AS CreditTable
     ON Vendors.VendorID = CreditTable.VendorID
GROUP BY VendorName;
