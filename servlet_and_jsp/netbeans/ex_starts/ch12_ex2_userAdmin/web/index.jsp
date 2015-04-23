<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>

<h1>Users</h1>

<table>

  <tr>
    <th>First Name</th>
    <th>Last Name</th>
    <th colspan="3">Email</th>
  </tr>

  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <c:forEach var="user" items="${users}">
  <tr>
    <td>${user.firstName}</td>
    <td>${user.lastName}</td>
    <td>${user.email}</td>
    <td><a href="userAdmin?action=display_user&amp;email=${user.email}">Update</a></td>
    <td><a href="userAdmin?action=delete_user&amp;email=${user.email}">Delete</a></td>
  </tr>
  </c:forEach>

</table>

<p><a href="userAdmin">Refresh</a></p>

</body>
</html>