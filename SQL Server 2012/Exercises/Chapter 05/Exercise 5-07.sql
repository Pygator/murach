USE AP;

SELECT VendorName, AccountDescription, COUNT(*) AS LineItemCount,
       SUM(InvoiceLineItemAmount) AS LineItemSum
FROM Vendors JOIN Invoices
   ON Vendors.VendorID = Invoices.VendorID
 JOIN InvoiceLineItems
   ON Invoices.InvoiceID = InvoiceLineItems.InvoiceID
 JOIN GLAccounts
   ON InvoiceLineItems.AccountNo = GLAccounts.AccountNo
GROUP BY VendorName, AccountDescription
ORDER BY VendorName, AccountDescription;
