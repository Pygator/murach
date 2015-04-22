USE AP;

CREATE TABLE Instructions
(InstructionsID int NOT NULL IDENTITY PRIMARY KEY,
Instructions xml NOT NULL);

DECLARE @InstructionsXML xml;
SET @InstructionsXML =
'
<Instructions>
  <Step>
    <Description>This is the first step.</Description>
    <SubStep>This is the first substep.</SubStep>
    <SubStep>This is the second substep.</SubStep>
  </Step>
  <Step>
    <Description>This is the second step.</Description>
  </Step>
  <Step>
    <Description>This is the third step.</Description>
  </Step>
</Instructions>
'
;

INSERT INTO Instructions VALUES (@InstructionsXML);

SELECT * FROM Instructions;