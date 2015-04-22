USE AP;

DECLARE @VendorName varchar(50), @InvoiceAvg money;
DECLARE Avg_Cursor CURSOR
STATIC
FOR
  SELECT VendorName, AVG(InvoiceTotal) AS InvoiceAvg
  FROM Vendors JOIN Invoices
    ON Vendors.VendorID = Invoices.VendorID
  GROUP BY VendorName;
OPEN Avg_Cursor;
FETCH NEXT FROM Avg_Cursor INTO @VendorName, @InvoiceAvg;
WHILE @@FETCH_STATUS = 0
  BEGIN
    PRINT @VendorName + ', $' + CONVERT(varchar, @InvoiceAvg, 1);
    FETCH NEXT FROM Avg_Cursor INTO @VendorName, @InvoiceAvg;
  END;
CLOSE Avg_Cursor;
DEALLOCATE Avg_Cursor;
