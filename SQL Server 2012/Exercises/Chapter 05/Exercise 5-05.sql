USE AP;

SELECT GLAccounts.AccountDescription, COUNT(*) AS LineItemCount,
       SUM(InvoiceLineItemAmount) AS LineItemSum
FROM GLAccounts JOIN InvoiceLineItems
  ON GLAccounts.AccountNo = InvoiceLineItems.AccountNo
 JOIN Invoices
   ON InvoiceLineItems.InvoiceID = Invoices.InvoiceID
WHERE InvoiceDate BETWEEN '2011-12-01' AND '2012-02-29'
GROUP BY GLAccounts.AccountDescription
HAVING COUNT(*) > 1
ORDER BY LineItemCount DESC;
