USE AP;

SELECT VendorName, InvoiceNumber, InvoiceDate 
FROM Vendors 
	JOIN Invoices ON Vendors.VendorID = Invoices.VendorID
WHERE InvoiceTotal - PaymentTotal - CreditTotal > 0
ORDER BY VendorName;