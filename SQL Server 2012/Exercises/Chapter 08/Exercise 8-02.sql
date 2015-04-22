USE AP;

SELECT CAST(InvoiceDate AS varchar) AS CastAsVarchar,
       CONVERT(varchar,InvoiceDate,1) AS ConvertToStyle1,
       CONVERT(varchar,InvoiceDate,10) AS ConvertToStyle10,
       CAST(InvoiceDate AS real) AS ConvertToReal
FROM Invoices;
