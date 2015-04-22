USE AP;

SELECT Summary1.VendorState, Summary1.VendorName, TopInState.SumOfInvoices
FROM
        (SELECT V_Sub.VendorState, V_Sub.VendorName,
            SUM(I_Sub.InvoiceTotal) AS SumOfInvoices
        FROM Invoices AS I_Sub JOIN Vendors AS V_Sub
            ON I_Sub.VendorID = V_Sub.VendorID
        GROUP BY V_Sub.VendorState, V_Sub.VendorName) AS Summary1
    JOIN
        (SELECT Summary2.VendorState,
            MAX(Summary2.SumOfInvoices) AS SumOfInvoices
        FROM
            (SELECT V_Sub.VendorState, V_Sub.VendorName,
                SUM(I_Sub.InvoiceTotal) AS SumOfInvoices
            FROM Invoices AS I_Sub JOIN Vendors AS V_Sub
                ON I_Sub.VendorID = V_Sub.VendorID
            GROUP BY V_Sub.VendorState, V_Sub.VendorName) AS Summary2
        GROUP BY Summary2.VendorState) AS TopInState
    ON Summary1.VendorState = TopInState.VendorState AND
       Summary1.SumOfInvoices = TopInState.SumOfInvoices
ORDER BY Summary1.VendorState;

