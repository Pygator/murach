CREATE TABLE Individuals
(IndividualID int NOT NULL IDENTITY PRIMARY KEY,
 FirstName varchar(50) NOT NULL,
 LastName varchar(50) NOT NULL,
 Address varchar(100) NULL,
 Phone varchar(50) NULL);

CREATE TABLE Groups
(GroupID int NOT NULL IDENTITY PRIMARY KEY,
 GroupName varchar(50) NOT NULL,
 Dues money NOT NULL DEFAULT 0 CHECK (Dues >= 0));

CREATE Table GroupMembership
(GroupID int REFERENCES Groups(GroupID),
 IndividualID int REFERENCES Individuals(IndividualID));
