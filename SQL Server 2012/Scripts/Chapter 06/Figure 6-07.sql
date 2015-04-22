USE AP;

SELECT VendorID, InvoiceNumber, InvoiceTotal
FROM Invoices AS Inv_Main
WHERE InvoiceTotal >
    (SELECT AVG(InvoiceTotal)
    FROM Invoices AS Inv_Sub
    WHERE Inv_Sub.VendorID = Inv_Main.VendorID)
ORDER BY VendorID, InvoiceTotal;

