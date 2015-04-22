USE AP;

UPDATE InvoiceCopy
SET TermsID = 1
WHERE VendorID IN
   (SELECT VendorID
    FROM VendorCopy
    WHERE VendorState IN ('CA', 'AZ', 'NV'));
