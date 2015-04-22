USE AP;

/*
This result set is better displayed using the "Results to Text" setting.

To use "Results to Text", click on the "Results to Text" button in the toolbar.
To return to "Results to Grid", click on the "Results to Grid" button in the toolbar.
*/

SELECT VendorName + CHAR(13) + CHAR(10)
     + VendorAddress1 + CHAR(13) + CHAR(10)
     + VendorCity + ', ' + VendorState + ' ' + VendorZipCode
FROM Vendors
WHERE VendorID = 1;
