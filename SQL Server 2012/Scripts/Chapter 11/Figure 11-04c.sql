USE New_AP;

CREATE TABLE VendorsSparse
(VendorID              INT           NOT NULL IDENTITY PRIMARY KEY,
VendorName             VARCHAR(50)   NOT NULL,
VendorAddress1         VARCHAR(50)   NULL,
VendorAddress2         VARCHAR(50)   SPARSE NULL);
