USE AP;

SELECT VendorName, InvoiceNumber, InvoiceDate,
       InvoiceLineItemAmount AS LineItemAmount, AccountDescription
FROM Vendors
    JOIN Invoices ON Vendors.VendorID = Invoices.VendorID
    JOIN InvoiceLineItems ON Invoices.InvoiceID = InvoiceLineItems.InvoiceID
    JOIN GLAccounts ON InvoiceLineItems.AccountNo = GLAccounts.AccountNo
WHERE InvoiceTotal - PaymentTotal - CreditTotal > 0
ORDER BY VendorName, LineItemAmount DESC;
