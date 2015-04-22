USE AP;

SELECT UserID, Email.Address AS EmailAddress, 
               Email.Domain  AS EmailDomain, Password FROM Users;