USE AP;

SELECT GLAccounts.AccountNo, AccountDescription
FROM GLAccounts LEFT JOIN InvoiceLineItems
  ON GLAccounts.AccountNo = InvoiceLineItems.AccountNo
WHERE InvoiceLineItems.AccountNo IS NULL
ORDER BY GLAccounts.AccountNo;
