USE AP;

-- The subquery
SELECT Summary2.VendorState, MAX(Summary2.SumOfInvoices) AS SumOfInvoices
FROM
    (SELECT V_Sub.VendorState, V_Sub.VendorName, SUM(I_Sub.InvoiceTotal) AS SumOfInvoices
     FROM Invoices AS I_Sub JOIN Vendors AS V_Sub
       ON I_Sub.VendorID = V_Sub.VendorID
     GROUP BY V_Sub.VendorState, V_Sub.VendorName) AS Summary2
GROUP BY Summary2.VendorState;