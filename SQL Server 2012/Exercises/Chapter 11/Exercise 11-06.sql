DROP TABLE GroupMembership;

CREATE Table GroupMembership
(GroupID int REFERENCES Groups(GroupID),
 IndividualID int REFERENCES Individuals(IndividualID),
 UNIQUE(GroupID, IndividualID));
