USE AP;

SELECT InvoiceNumber, InvoiceLineItemAmount, InvoiceLineItemDescription
FROM Invoices JOIN InvoiceLineItems AS LineItems
    ON Invoices.InvoiceID = LineItems.InvoiceID
WHERE AccountNo = 540
ORDER BY InvoiceDate;
