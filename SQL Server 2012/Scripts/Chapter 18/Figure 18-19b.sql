/*
To demonstrate application roles, be sure you log
in as TestAppRole before running this script.
*/

USE AP;

SELECT * FROM Invoices;
EXEC sp_SetAppRole AppInvoiceQuery, appqrypw;
SELECT * FROM Invoices;

/*
Afterward, login using your Windows account
and then run Figure 17-16c.sql.
*/