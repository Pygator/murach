USE AP;
IF OBJECT_ID('tempdb..#InvoiceCopy') IS NOT NULL
    DROP TABLE #InvoiceCopy;

SELECT * INTO #InvoiceCopy FROM Invoices 
WHERE InvoiceTotal - CreditTotal - PaymentTotal > 0;

WHILE (SELECT SUM(InvoiceTotal - CreditTotal - PaymentTotal) 
        FROM #InvoiceCopy) >= 20000
    BEGIN
        UPDATE #InvoiceCopy
        SET CreditTotal = CreditTotal + .05
        WHERE InvoiceTotal - CreditTotal - PaymentTotal > 0;

        IF (SELECT MAX(CreditTotal) FROM #InvoiceCopy) > 3000
            BREAK;
        ELSE --(SELECT MAX(CreditTotal) FROM #InvoiceCopy) <= 3000
            CONTINUE;
    END;

SELECT InvoiceDate, InvoiceTotal, CreditTotal
FROM #InvoiceCopy;