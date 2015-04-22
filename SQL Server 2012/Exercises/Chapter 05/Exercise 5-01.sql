USE AP;

SELECT VendorID, SUM(PaymentTotal) AS PaymentSum
FROM Invoices
GROUP BY VendorID;
