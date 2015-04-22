USE AP;

UPDATE InvoiceCopy
SET TermsID = 1
FROM InvoiceCopy JOIN VendorCopy
    ON InvoiceCopy.VendorID = VendorCopy.VendorID
WHERE VendorName = 'Pacific Bell';
