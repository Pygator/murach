USE AP;

SELECT ROW_NUMBER() OVER(ORDER BY VendorName) AS RowNumber, VendorName
FROM Vendors;
