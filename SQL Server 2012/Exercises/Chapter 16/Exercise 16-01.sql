USE AP;

DECLARE Avg_Cursor CURSOR
STATIC
FOR
  SELECT VendorName, AVG(InvoiceTotal) AS InvoiceAvg
  FROM Vendors JOIN Invoices
    ON Vendors.VendorID = Invoices.VendorID
  GROUP BY VendorName;
OPEN Avg_Cursor;
FETCH NEXT FROM Avg_Cursor;
WHILE @@FETCH_STATUS = 0
  FETCH NEXT FROM Avg_Cursor;
CLOSE Avg_Cursor;
DEALLOCATE Avg_Cursor;
