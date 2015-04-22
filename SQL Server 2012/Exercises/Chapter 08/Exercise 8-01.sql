USE AP;

SELECT CAST(InvoiceTotal AS decimal(17,2)) AS CastAsDecimal,
       CAST(InvoiceTotal AS varchar) AS CastAsVarchar,
       CONVERT(decimal(17,2),InvoiceTotal) AS ConvertToDecimal,
       CONVERT(varchar,InvoiceTotal,1) AS ConvertToVarchar
FROM Invoices;
