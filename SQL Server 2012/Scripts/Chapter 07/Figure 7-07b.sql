USE AP;

UPDATE VendorCopy
SET VendorContactLName = LastName,
    VendorContactFName = FirstName
FROM VendorCopy JOIN ContactUpdates
    ON VendorCopy.VendorID = ContactUpdates.VendorID;
