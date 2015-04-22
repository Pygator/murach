USE AP;

IF OBJECT_ID('DDLActivityLog3') IS NOT NULL
    DROP TABLE DDLActivityLog3;

IF  EXISTS 
	(SELECT * FROM sys.xml_schema_collections
	 WHERE name = 'EventDataSchema')
BEGIN
	DROP XML SCHEMA COLLECTION EventDataSchema;
END;

CREATE XML SCHEMA COLLECTION EventDataSchema
AS 
'
<xs:schema attributeFormDefault="unqualified" 
elementFormDefault="qualified" 
xmlns:xs="http://www.w3.org/2001/XMLSchema">
  <xs:element name="EVENT_INSTANCE">
    <xs:complexType>
      <xs:sequence>
        <xs:element name="EventType" type="xs:string" />
        <xs:element name="PostTime" type="xs:dateTime" />
        <xs:element name="SPID" type="xs:unsignedByte" />
        <xs:element name="ServerName" type="xs:string" />
        <xs:element name="LoginName" type="xs:string" />
        <xs:element name="UserName" type="xs:string" />
        <xs:element name="DatabaseName" type="xs:string" />
        <xs:element name="SchemaName" type="xs:string" />
        <xs:element name="ObjectName" type="xs:string" />
        <xs:element name="ObjectType" type="xs:string" />
        <xs:element name="TSQLCommand">
          <xs:complexType>
            <xs:sequence>
              <xs:element name="SetOptions">
                <xs:complexType>
                  <xs:attribute name="ANSI_NULLS" 
                      type="xs:string" use="required" />
                  <xs:attribute name="ANSI_NULL_DEFAULT" 
                      type="xs:string" use="required" />
                  <xs:attribute name="ANSI_PADDING" 
                      type="xs:string" use="required" />
                  <xs:attribute name="QUOTED_IDENTIFIER" 
                      type="xs:string" use="required" />
                  <xs:attribute name="ENCRYPTED" 
                      type="xs:string" use="required" />
                </xs:complexType>
              </xs:element>
              <xs:element name="CommandText" type="xs:string" />
            </xs:sequence>
          </xs:complexType>
        </xs:element>
      </xs:sequence>
    </xs:complexType>
  </xs:element>
</xs:schema>
'
;