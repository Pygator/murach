USE AP;

SELECT AccountNo, AccountDescription
FROM GLAccounts
WHERE NOT EXISTS
    (SELECT *
     FROM InvoiceLineItems
     WHERE InvoiceLineItems.AccountNo = GLAccounts.AccountNo)
ORDER BY AccountNo;
