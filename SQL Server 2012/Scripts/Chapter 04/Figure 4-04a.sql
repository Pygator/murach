USE AP;

SELECT InvoiceNumber, InvoiceDate,
    InvoiceTotal, InvoiceLineItemAmount
FROM Invoices JOIN InvoiceLineItems AS LineItems
    ON (Invoices.InvoiceID = LineItems.InvoiceID) AND
       (Invoices.InvoiceTotal > LineItems.InvoiceLineItemAmount)
ORDER BY InvoiceNumber;
