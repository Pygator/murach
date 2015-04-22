USE AP;

SELECT AccountNo, SUM(InvoiceLineItemAmount) AS LineItemSum
FROM InvoiceLineItems
GROUP BY AccountNo WITH ROLLUP;
