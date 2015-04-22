USE AP;

SELECT InvoiceNumber, InvoiceDate, InvoiceTotal, InvoiceLineItemDescription AS ItemDescription, InvoiceLineItemAmount AS ItemAmount
FROM Invoices AS Invoice JOIN InvoiceLineItems AS LineItem
    ON Invoice.InvoiceID = LineItem.InvoiceID 
WHERE Invoice.InvoiceID IN (
    SELECT Invoices.InvoiceID
    FROM Invoices JOIN InvoiceLineItems
        ON Invoices.InvoiceID = InvoiceLineItems.InvoiceID 
    GROUP BY Invoices.InvoiceID
    HAVING COUNT(InvoiceLineItemDescription) > 1)
ORDER BY InvoiceDate 
FOR XML AUTO, ROOT ('MultipleLineItems'), ELEMENTS;
