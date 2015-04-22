USE AP;

SELECT GLAccounts.AccountDescription, COUNT(*) AS LineItemCount,
       SUM(InvoiceLineItemAmount) AS LineItemSum
FROM GLAccounts JOIN InvoiceLineItems
  ON GLAccounts.AccountNo = InvoiceLineItems.AccountNo
GROUP BY GLAccounts.AccountDescription
HAVING COUNT(*) > 1
ORDER BY LineItemCount DESC;
