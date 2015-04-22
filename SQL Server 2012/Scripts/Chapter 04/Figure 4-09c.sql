USE Examples;

SELECT DeptName, Departments.DeptNo, LastName
FROM Departments LEFT JOIN Employees
    ON Departments.DeptNo = Employees.DeptNo;
