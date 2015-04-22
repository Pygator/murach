<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Murach's Java Servlets and JSP</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
    </head>
    <body>
        <h1>Request Headers</h1>
        <table>
            <tr>
                <th>Name</th>
                <th>Value</th>
            </tr>
            <c:forEach var="headers" items="${headers}">
                <tr>
                    <td><c:out value="${headers.key}"/></td>
                    <td><c:out value="${headers.value}"/></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>