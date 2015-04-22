USE AP;

SELECT VendorName, InvoiceNumber AS FirstInv,
       InvoiceDate, InvoiceTotal
FROM Invoices AS I_Main JOIN Vendors
  ON I_Main.VendorID = Vendors.VendorID
WHERE InvoiceDate =
  (SELECT MIN(InvoiceDate)
   FROM Invoices AS I_Sub
   WHERE I_Sub.VendorID = I_Main.VendorID)
ORDER BY VendorName;
