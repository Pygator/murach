<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>    
</head>

<body>
    <h1>Thanks for joining our email list</h1>

    <p>Here is the information that you entered:</p>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    <label>Email:</label>
    <span><c:out value="${user.email}" /></span><br>
    <label>First Name:</label>
    <span><c:out value="${user.firstName}" /></span><br>
    <label>Last Name:</label>
    <span><c:out value="${user.lastName}" /></span><br>

    <p>To enter another email address, click on the Back 
    button in your browser or the Return button shown 
    below.</p>

    <form action="" method="get">
        <input type="hidden" name="action" value="join">
        <input type="submit" value="Return">
    </form>

    
<table>
  <tr>
    <th>Name</th>
    <th>Value</th>
  </tr>
  <c:forEach var="cook" items="${cookie}">
  <tr>
    <td><c:out value="${cook.value.name}" /></td>
    <td><c:out value="${cook.value.value}" /></td>
  </tr>
  </c:forEach>  
</table>
    
</body>
</html>