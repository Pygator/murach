USE AP;
GO

IF OBJECT_ID('Users') IS NOT NULL
    DROP TABLE Users;
GO

CREATE TABLE Users(
	UserID int NOT NULL IDENTITY PRIMARY KEY, 
	Email email UNIQUE, 
	Password nvarchar(50));