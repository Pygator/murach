USE AP;

DELETE InvoiceCopy
WHERE VendorID = 
   (SELECT VendorID
    FROM VendorCopy 
    WHERE VendorName = 'Blue Cross');
