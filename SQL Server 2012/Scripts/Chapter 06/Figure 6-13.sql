USE AP;

WITH Summary AS
(
    SELECT VendorState, VendorName, SUM(InvoiceTotal) AS SumOfInvoices
    FROM Invoices 
        JOIN Vendors ON Invoices.VendorID = Vendors.VendorID
    GROUP BY VendorState, VendorName
),

TopInState AS
(
	SELECT VendorState, MAX(SumOfInvoices) AS SumOfInvoices
    FROM Summary
    GROUP BY VendorState
)

SELECT Summary.VendorState, Summary.VendorName, TopInState.SumOfInvoices
FROM Summary JOIN TopInState
    ON Summary.VendorState = TopInState.VendorState AND
       Summary.SumOfInvoices = TopInState.SumOfInvoices
ORDER BY Summary.VendorState;