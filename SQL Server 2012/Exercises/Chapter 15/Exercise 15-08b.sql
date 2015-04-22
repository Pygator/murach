USE AP;
GO

CREATE TRIGGER Invoices_UPDATE_Shipping
    ON Invoices
    AFTER INSERT, UPDATE
AS
    INSERT ShippingLabels
    SELECT VendorName, VendorAddress1, VendorAddress2,
           VendorCity, VendorState, VendorZipCode
    FROM Vendors JOIN Inserted
      ON Vendors.VendorID = (SELECT VendorID FROM Inserted)
    WHERE Inserted.InvoiceTotal - Inserted.PaymentTotal
        - Inserted.CreditTotal = 0;