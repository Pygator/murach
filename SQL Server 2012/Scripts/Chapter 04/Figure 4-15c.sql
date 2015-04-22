USE Examples;

	SELECT CustomerFirst, CustomerLast 
	FROM Customers
EXCEPT
	SELECT FirstName, LastName 
	FROM Employees
ORDER BY CustomerLast;