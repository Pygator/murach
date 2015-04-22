USE AP;

BEGIN TRAN;
  INSERT InvoiceArchive
  SELECT Invoices.*
  FROM Invoices LEFT JOIN InvoiceArchive
    ON Invoices.InvoiceID = InvoiceArchive.InvoiceID
  WHERE Invoices.InvoiceTotal - Invoices.CreditTotal -
          Invoices.PaymentTotal = 0 AND
        InvoiceArchive.InvoiceID IS NULL;

  DELETE Invoices
  WHERE InvoiceID IN
    (SELECT InvoiceID
     FROM InvoiceArchive);
COMMIT TRAN;
