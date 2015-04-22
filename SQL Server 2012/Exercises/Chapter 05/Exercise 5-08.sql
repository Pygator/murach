USE AP;

SELECT VendorName,
       COUNT(DISTINCT InvoiceLineItems.AccountNo) AS [# of Accounts]
FROM Vendors JOIN Invoices
  ON Vendors.VendorID = Invoices.VendorID
 JOIN InvoiceLineItems
   ON Invoices.InvoiceID = InvoiceLineItems.InvoiceID
GROUP BY VendorName
HAVING COUNT(DISTINCT InvoiceLineItems.AccountNo) > 1
ORDER BY VendorName;
