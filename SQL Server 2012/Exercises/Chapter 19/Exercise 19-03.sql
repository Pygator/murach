USE AP;

-- Declare an int variable that's a handle for the internal XML document
DECLARE @ContactUpdatesHandle int;

-- Create an xml variable that stores the XML document
DECLARE @ContactUpdates xml;
SET @ContactUpdates = '
<ContactUpdates>
  <Contact VendorID="4">
    <LastName>McCrystle</LastName>
    <FirstName>Timothy</FirstName>
  </Contact>
  <Contact VendorID="10">
    <LastName>Flynn</LastName>
    <FirstName>Erin</FirstName>
  </Contact>
</ContactUpdates>
'
;

-- Prepare the internal XML document
EXEC sp_Xml_PrepareDocument @ContactUpdatesHandle OUTPUT, @ContactUpdates;

-- SELECT the data from the table returned by the OPENXML statement
SELECT *
FROM OPENXML (@ContactUpdatesHandle, '/ContactUpdates/Contact') 
WITH
(
	VendorID   int          '@VendorID', 
	FirstName  varchar(50)  'FirstName', 
	LastName   varchar(50)  'LastName'
);

-- Remove the internal XML document
EXEC sp_Xml_RemoveDocument @ContactUpdatesHandle;
