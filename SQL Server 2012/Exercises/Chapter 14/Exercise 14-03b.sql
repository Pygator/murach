USE AP;

SELECT VendorName, FirstInvoiceDate, InvoiceTotal
FROM Invoices JOIN FirstInvoice_V
  ON (Invoices.VendorID = FirstInvoice_V.VendorID AND
      Invoices.InvoiceDate = FirstInvoice_V.FirstInvoiceDate)
JOIN Vendors
  ON Invoices.VendorID = Vendors.VendorID
ORDER BY VendorName, FirstInvoiceDate;
