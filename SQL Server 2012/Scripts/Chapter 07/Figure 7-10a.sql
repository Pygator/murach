USE AP;

MERGE INTO InvoiceArchive AS ia
USING InvoiceCopy AS ic
ON ic.InvoiceID = ia.InvoiceID
WHEN MATCHED AND 
    ic.PaymentDate IS NOT NULL AND
    ic.PaymentTotal > ia.PaymentTotal
  THEN
  UPDATE SET 
    ia.PaymentTotal = ic.PaymentTotal, 
    ia.CreditTotal = ic.CreditTotal, 
    ia.PaymentDate = ic.PaymentDate
WHEN NOT MATCHED THEN
  INSERT (InvoiceID, VendorID, InvoiceNumber, 
    InvoiceTotal, PaymentTotal, CreditTotal,
    TermsID, InvoiceDate, InvoiceDueDate)
  VALUES (ic.InvoiceID, ic.VendorID, ic.InvoiceNumber, 
    ic.InvoiceTotal, ic.PaymentTotal, ic.CreditTotal,
    ic.TermsID, ic.InvoiceDate, ic.InvoiceDueDate)
WHEN NOT MATCHED BY SOURCE THEN
    DELETE
;