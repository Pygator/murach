USE AP;

UPDATE InvoiceCopy
SET TermsID = 2
FROM InvoiceCopy JOIN VendorCopy
  ON InvoiceCopy.VendorID = VendorCopy.VendorID
WHERE DefaultTermsID = 2;
