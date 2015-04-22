USE AP;

SELECT VendorName, InvoiceNumber, InvoiceDate,
    InvoiceLineItemAmount AS LineItemAmount, AccountDescription
FROM Vendors, Invoices, InvoiceLineItems, GLAccounts
WHERE Vendors.VendorID = Invoices.VendorID
  AND Invoices.InvoiceID = InvoiceLineItems.InvoiceID
  AND InvoiceLineItems.AccountNo = GLAccounts.AccountNo
  AND InvoiceTotal - PaymentTotal - CreditTotal > 0
ORDER BY VendorName, LineItemAmount DESC;
