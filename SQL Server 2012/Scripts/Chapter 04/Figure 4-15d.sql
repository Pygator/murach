USE Examples;

	SELECT CustomerFirst, CustomerLast 
	FROM Customers
INTERSECT
	SELECT FirstName, LastName 
	FROM Employees;
