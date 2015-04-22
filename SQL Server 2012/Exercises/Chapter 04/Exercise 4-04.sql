USE AP;

SELECT VendorName, InvoiceNumber, InvoiceDate,
       InvoiceTotal - PaymentTotal - CreditTotal AS Balance
FROM Vendors, Invoices
WHERE Vendors.VendorID = Invoices.VendorID
  AND InvoiceTotal - PaymentTotal - CreditTotal > 0
ORDER BY VendorName;