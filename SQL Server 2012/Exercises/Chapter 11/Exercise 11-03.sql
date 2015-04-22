CREATE CLUSTERED INDEX IX_GroupMembership_GroupID
    ON GroupMembership(GroupID)
CREATE INDEX IX_GroupMembership_IndividualID
    ON GroupMembership(IndividualID);
