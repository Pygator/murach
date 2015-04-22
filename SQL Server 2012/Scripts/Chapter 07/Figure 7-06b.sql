USE AP;

UPDATE InvoiceCopy
SET TermsID = 1
WHERE VendorID =
   (SELECT VendorID
    FROM VendorCopy
    WHERE VendorName = 'Pacific Bell');
