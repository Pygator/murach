USE AP;

-- The subquery
SELECT AVG(InvoiceTotal)
FROM Invoices AS Inv_Sub
--WHERE Inv_Sub.VendorID = Inv_Main.VendorID
WHERE Inv_Sub.VendorID = 95;
