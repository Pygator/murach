USE AP;

-- drop all objects that reference the assembly
IF OBJECT_ID('GetInvoiceReport') IS NOT NULL
    DROP PROC GetInvoiceReport;
IF OBJECT_ID('GetInvoiceTotalSum') IS NOT NULL
    DROP PROC GetInvoiceTotalSum;
IF OBJECT_ID('GetInvoiceCount') IS NOT NULL
	DROP PROC GetInvoiceCount;
IF OBJECT_ID('InsertInvoiceTest') IS NOT NULL
    DROP PROC InsertInvoiceTest;
IF OBJECT_ID('InsertInvoice') IS NOT NULL
    DROP PROC InsertInvoice;
IF OBJECT_ID('InsertInvoiceWithDefaultValues') IS NOT NULL
    DROP PROC InsertInvoiceWithDefaultValues;

-- drop the assembly
IF ASSEMBLYPROPERTY('ApClrObjects', 'SimpleName') IS NOT NULL
    DROP ASSEMBLY ApClrObjects;
GO

-- create the assembly from the dll
CREATE ASSEMBLY ApClrObjects
FROM 'C:\Murach\SQL Server 2012\Projects\C#\Chapter 21\ApClrObjects\ApClrObjects\bin\Debug\ApClrObjects.dll';