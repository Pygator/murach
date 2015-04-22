USE Examples;

SELECT DeptName, LastName, EmployeeID
FROM Departments 
    JOIN Employees
        ON Departments.DeptNo = Employees.DeptNo;
