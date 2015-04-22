USE AP;

SELECT ROW_NUMBER() OVER(PARTITION BY VendorState 
    ORDER BY VendorName) As RowNumber, VendorName, VendorState
FROM Vendors;
