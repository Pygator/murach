USE AP;

SELECT VendorName, FunctionTable.*
FROM Vendors JOIN Invoices
  ON Vendors.VendorID = Invoices.VendorID
JOIN dbo.fnDateRange('12/10/11','12/20/11') AS FunctionTable
  ON Invoices.InvoiceNumber = FunctionTable.InvoiceNumber;
