USE AP;
GO
IF OBJECT_ID('IBM_Invoices_INSERT') IS NOT NULL
    DROP TRIGGER IBM_Invoices_INSERT;
GO

CREATE TRIGGER IBM_Invoices_INSERT
    ON IBM_Invoices
    INSTEAD OF INSERT
AS
DECLARE @InvoiceDate smalldatetime, @InvoiceNumber varchar(50),
        @InvoiceTotal money, @VendorID int,
        @InvoiceDueDate smalldatetime, @TermsID int,
        @DefaultTerms smallint, @TestRowCount int;
SELECT @TestRowCount = COUNT(*) FROM Inserted;
IF @TestRowCount = 1
    BEGIN
        SELECT @InvoiceNumber = InvoiceNumber, @InvoiceDate = InvoiceDate,
            @InvoiceTotal = InvoiceTotal
        FROM Inserted;
        IF (@InvoiceDate IS NOT NULL AND @InvoiceNumber IS NOT NULL AND
            @InvoiceTotal IS NOT NULL)
            BEGIN
                SELECT @VendorID = VendorID, @TermsID = DefaultTermsID
                FROM Vendors 
                WHERE VendorName = 'IBM';

                SELECT @DefaultTerms = TermsDueDays
                FROM Terms
                WHERE TermsID = @TermsID;

                SET @InvoiceDueDate = @InvoiceDate + @DefaultTerms;

                INSERT Invoices
                   (VendorID, InvoiceNumber, InvoiceDate, InvoiceTotal,
                    TermsID, InvoiceDueDate, PaymentDate)
                VALUES (@VendorID, @InvoiceNumber, @InvoiceDate,
                   @InvoiceTotal, @TermsID, @InvoiceDueDate, NULL);
            END;
    END;
ELSE
	THROW 50027, 'Limit INSERT to a single row.', 1;
