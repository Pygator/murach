USE AP;

SELECT
  CASE
    WHEN GROUPING(AccountDescription) = 1 THEN '*ALL*'
    ELSE AccountDescription
  END AS Account,
  CASE
    WHEN GROUPING(VendorState) = 1 THEN '*ALL*'
    ELSE VendorState
  END AS State,
  SUM(InvoiceLineItemAmount) AS LineItemSum
FROM GLAccounts JOIN InvoiceLineItems 
  ON GLAccounts.AccountNo = InvoiceLineItems.AccountNo
 JOIN Invoices
   ON InvoiceLineItems.InvoiceID =  Invoices.InvoiceID
 JOIN Vendors
   ON Invoices.VendorID = Vendors.VendorID
GROUP BY AccountDescription, VendorState WITH CUBE;
