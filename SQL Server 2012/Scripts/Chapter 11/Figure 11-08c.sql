USE New_AP;

CREATE TABLE Vendors1
(VendorCode      CHAR(6)     NOT NULL PRIMARY KEY,
VendorName       VARCHAR(50) NOT NULL,
CHECK     ((VendorCode LIKE '[A-Z][A-Z][0-9][0-9][0-9][0-9]') AND
           (LEFT(VendorCode,2) = LEFT(VendorName,2))));
