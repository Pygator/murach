USE AP;

DELETE VendorCopy
WHERE VendorID NOT IN 
   (SELECT DISTINCT VendorID FROM InvoiceCopy);
