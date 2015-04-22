USE AP;
GO

IF OBJECT_ID('VendorsTest') IS NOT NULL
    DROP TABLE VendorsTest;

CREATE TABLE VendorsTest
(VendorID int, VendorName varchar(50));
