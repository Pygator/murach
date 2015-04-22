USE Examples;

WITH EmployeesCTE AS
(
		-- Anchor member
		SELECT EmployeeID, 
			FirstName + ' ' + LastName As EmployeeName, 
			1 As Rank
		FROM Employees
		WHERE ManagerID IS NULL
	UNION ALL
		-- Recursive member
		SELECT Employees.EmployeeID, 
			FirstName + ' ' + LastName, 
			Rank + 1
		FROM Employees
			JOIN EmployeesCTE
			ON Employees.ManagerID = EmployeesCTE.EmployeeID
)
SELECT *
FROM EmployeesCTE
ORDER BY Rank, EmployeeID;