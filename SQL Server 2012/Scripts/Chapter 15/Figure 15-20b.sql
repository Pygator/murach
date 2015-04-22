USE AP;

IF OBJECT_ID('Invoices_UPDATE') IS NOT NULL
    DROP TRIGGER Invoices_UPDATE;
GO

CREATE TRIGGER Invoices_UPDATE
    ON Invoices
    AFTER UPDATE
AS
IF EXISTS           --Test whether PaymentTotal was changed
 (SELECT *
  FROM Deleted JOIN Invoices
    ON Deleted.InvoiceID = Invoices.InvoiceID
  WHERE Deleted.PaymentTotal <> Invoices.PaymentTotal)
  BEGIN
    IF EXISTS       --Test whether line items total and InvoiceTotal match
     (SELECT *
      FROM Invoices JOIN
          (SELECT InvoiceID, SUM(InvoiceLineItemAmount) AS SumOfInvoices
           FROM InvoiceLineItems
           GROUP BY InvoiceID) AS LineItems
        ON Invoices.InvoiceID = LineItems.InvoiceID
      WHERE (Invoices.InvoiceTotal <> LineItems.SumOfInvoices) AND
            (LineItems.InvoiceID IN (SELECT InvoiceID FROM Deleted)))
      BEGIN
        ;
        THROW 50113, 'Correct line item amounts before posting payment.', 1;
        ROLLBACK TRAN;
      END;
  END;