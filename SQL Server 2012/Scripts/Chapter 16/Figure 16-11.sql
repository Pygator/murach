USE AP;

IF OBJECT_ID('spOpenInvoices') IS NOT NULL
    DROP PROC spOpenInvoices;
IF OBJECT_ID('spGetInvoice') IS NOT NULL
    DROP PROC spGetInvoice;
IF OBJECT_ID('spCloseInvoices') IS NOT NULL
    DROP PROC spCloseInvoices;
GO

CREATE PROC spOpenInvoices
AS
    DECLARE Invoices_Cursor CURSOR
    GLOBAL SCROLL DYNAMIC
    FOR
        SELECT *
        FROM Invoices WHERE InvoiceTotal - CreditTotal - PaymentTotal > 0;
    OPEN Invoices_Cursor;
GO

CREATE PROC spGetInvoice
  @InvoiceID      int           OUTPUT, @VendorID     int           OUTPUT,
  @InvoiceNumber  varchar(50)   OUTPUT, @InvoiceDate  smalldatetime OUTPUT,
  @InvoiceTotal   money         OUTPUT, @PaymentTotal money         OUTPUT,
  @CreditTotal    money         OUTPUT, @TermsID      int           OUTPUT,
  @InvoiceDueDate smalldatetime OUTPUT, @PaymentDate  smalldatetime OUTPUT
AS
    FETCH NEXT FROM Invoices_Cursor INTO
      @InvoiceID, @VendorID, @InvoiceNumber, @InvoiceDate, @InvoiceTotal,
      @PaymentTotal, @CreditTotal, @TermsID, @InvoiceDueDate, @PaymentDate;
    RETURN @@FETCH_STATUS;
GO

CREATE PROC spCloseInvoices
AS
    CLOSE Invoices_Cursor;
    DEALLOCATE Invoices_Cursor;