USE AP;

DELETE VendorCopy
WHERE VendorState NOT IN
  (SELECT DISTINCT VendorState
   FROM VendorCopy JOIN InvoiceCopy
     ON VendorCopy.VendorID = InvoiceCopy.VendorID);
