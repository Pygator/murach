USE AP;

-- Declare an int variable that's a handle for the internal XML document
DECLARE @VendorInvoicesHandle int;

-- Create an xml variable that stores the XML document
DECLARE @VendorInvoices xml;
SET @VendorInvoices = '
<Vendors>
  <Vendor>
    <VendorName>Abbey Office Furnishings</VendorName>
    <Invoice>
      <InvoiceNumber>203339-13</InvoiceNumber>
      <InvoiceTotal>17.5000</InvoiceTotal>
    </Invoice>
  </Vendor>
  <Vendor>
    <VendorName>Bertelsmann Industry Svcs. Inc</VendorName>
    <Invoice>
      <InvoiceNumber>509786</InvoiceNumber>
      <InvoiceTotal>6940.2500</InvoiceTotal>
    </Invoice>
  </Vendor>
  <Vendor>
    <VendorName>Blue Cross</VendorName>
    <Invoice>
      <InvoiceNumber>547479217</InvoiceNumber>
      <InvoiceTotal>116.0000</InvoiceTotal>
    </Invoice>
    <Invoice>
      <InvoiceNumber>547480102</InvoiceNumber>
      <InvoiceTotal>224.0000</InvoiceTotal>
    </Invoice>
    <Invoice>
      <InvoiceNumber>547481328</InvoiceNumber>
      <InvoiceTotal>224.0000</InvoiceTotal>
    </Invoice>
  </Vendor>
</Vendors>
'
;

-- Prepare the internal XML document
EXEC SP_XML_PREPAREDOCUMENT @VendorInvoicesHandle OUTPUT, @VendorInvoices;

-- SELECT the data from the table returned by the OPENXML function
SELECT * 
FROM OPENXML (@VendorInvoicesHandle, '/Vendors/Vendor/Invoice') 
WITH
(
    VendorName    varchar(50) '../VendorName', 
    InvoiceNumber varchar(50) 'InvoiceNumber', 
    InvoiceTotal  money       'InvoiceTotal'
);

-- Remove the internal XML document
EXEC SP_XML_REMOVEDOCUMENT @VendorInvoicesHandle;