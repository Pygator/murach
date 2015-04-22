USE AP;

-- The subquery
SELECT V_Sub.VendorState, V_Sub.VendorName, SUM(I_Sub.InvoiceTotal) AS SumOfInvoices
FROM Invoices AS I_Sub JOIN Vendors AS V_Sub
  ON I_Sub.VendorID = V_Sub.VendorID
GROUP BY V_Sub.VendorState, V_Sub.VendorName;