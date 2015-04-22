USE AP;

IF OBJECT_ID('fnTopVendorsDue') IS NOT NULL
    DROP FUNCTION fnTopVendorsDue;
GO

CREATE FUNCTION fnTopVendorsDue
    (@CutOff money = 0)
    RETURNS TABLE
RETURN
	(SELECT VendorName, SUM(InvoiceTotal) AS TotalDue
	FROM Vendors JOIN Invoices ON Vendors.VendorID = Invoices.VendorID
	WHERE InvoiceTotal - CreditTotal - PaymentTotal > 0
	GROUP BY VendorName
	HAVING SUM(InvoiceTotal) >= @CutOff);
