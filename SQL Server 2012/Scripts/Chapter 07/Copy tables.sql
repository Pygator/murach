-- Run this script to restore the VendorCopy and InvoiceCopy tables 
-- that are used throughout this chapter

USE AP;

IF OBJECT_ID('VendorCopy') IS NOT NULL
   DROP TABLE VendorCopy;

SELECT *
INTO VendorCopy
FROM Vendors;

IF OBJECT_ID('InvoiceCopy') IS NOT NULL
   DROP TABLE InvoiceCopy;

SELECT *
INTO InvoiceCopy
FROM Invoices;