USE AP;

SELECT RANK() OVER (ORDER BY InvoiceTotal) As Rank, 
       DENSE_RANK() OVER (ORDER BY InvoiceTotal) As DenseRank,
       InvoiceTotal, InvoiceNumber
FROM Invoices;
