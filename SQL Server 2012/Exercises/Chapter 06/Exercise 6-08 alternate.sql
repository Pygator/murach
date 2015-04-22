USE AP;

SELECT VendorName, InvoiceNumber AS FirstInv,
       FirstInvoice.InvoiceDate, InvoiceTotal
FROM Invoices JOIN
  (SELECT VendorID, MIN(InvoiceDate) AS InvoiceDate
   FROM Invoices
   GROUP BY VendorID) AS FirstInvoice
  ON (Invoices.VendorID = FirstInvoice.VendorID AND
      Invoices.InvoiceDate = FirstInvoice.InvoiceDate)
JOIN Vendors
  ON Invoices.VendorID = Vendors.VendorID
ORDER BY VendorName;
