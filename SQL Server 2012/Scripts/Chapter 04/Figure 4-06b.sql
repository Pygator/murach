USE AP;

SELECT VendorName, InvoiceNumber, InvoiceDate, 
	InvoiceLineItemAmount AS LineItemAmount
FROM Vendors 
	JOIN Invoices ON Vendors.VendorID = Invoices.VendorID
    JOIN InvoiceLineItems On Invoices.InvoiceID = InvoiceLineItems.InvoiceID
WHERE InvoiceTotal - PaymentTotal - CreditTotal > 0
ORDER BY VendorName, LineItemAmount;