USE AP;

UPDATE InvoiceCopy
SET CreditTotal = CreditTotal + 100,
    InvoiceDueDate = (SELECT MAX(InvoiceDueDate) FROM InvoiceCopy)
WHERE InvoiceNumber = '97/522';
