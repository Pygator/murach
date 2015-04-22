USE Examples;
GO

CREATE VIEW InvestorsGeneral
AS
SELECT InvestorID, LastName, FirstName, Address, 
    City, State, ZipCode, Phone
FROM Investors;