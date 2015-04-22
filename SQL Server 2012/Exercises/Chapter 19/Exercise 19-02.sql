USE AP;

DECLARE @ContactUpdate XML;
SET @ContactUpdate = '
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

UPDATE Vendors
SET VendorContactLName = @ContactUpdate.value(
    '(/ContactUpdates/Contact/LastName)[1]', 'varchar(50)'), 
  VendorContactFName = @ContactUpdate.value(
    '(/ContactUpdates/Contact/FirstName)[1]', 'varchar(50)')
WHERE VendorID = @ContactUpdate.value(
    '(/ContactUpdates/Contact/@VendorID)[1]', 'int');

UPDATE Vendors
SET VendorContactLName = @ContactUpdate.value(
    '(/ContactUpdates/Contact/LastName)[2]', 'varchar(50)'), 
  VendorContactFName = @ContactUpdate.value(
    '(/ContactUpdates/Contact/FirstName)[2]', 'varchar(50)')
WHERE VendorID = @ContactUpdate.value(
    '(/ContactUpdates/Contact/@VendorID)[2]', 'int');
