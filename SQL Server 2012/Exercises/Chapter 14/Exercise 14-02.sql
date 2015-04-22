USE AP;

IF OBJECT_ID('tempdb..#FirstInvoice') IS NOT NULL
    DROP TABLE #FirstInvoice;

SELECT VendorID, MIN(InvoiceDate) AS FirstInvoiceDate
INTO #FirstInvoice
FROM Invoices
GROUP BY VendorID;

SELECT VendorName, FirstInvoiceDate, InvoiceTotal
FROM Invoices JOIN #FirstInvoice
  ON (Invoices.VendorID = #FirstInvoice.VendorID AND
      Invoices.InvoiceDate = #FirstInvoice.FirstInvoiceDate)
JOIN Vendors
  ON Invoices.VendorID = Vendors.VendorID
ORDER BY VendorName, FirstInvoiceDate;
