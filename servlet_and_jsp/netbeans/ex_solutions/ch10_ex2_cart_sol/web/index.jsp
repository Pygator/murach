<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>
    
<h1>CD list</h1>
<table>
    <tr>
        <th>Description</th>
        <th class="right">Price</th>
        <th>&nbsp;</th>
    </tr>
    
    <%@ taglib uri="/WEB-INF/murach.tld" prefix="mma" %>
    <mma:products>  
    <tr>
        <td>${description}</td>
        <td class="right">${price}</td>
        <td><form action="cart" method="post">
                <input type="hidden" name="productCode" value="${code}">
                <input type="submit" value="Add To Cart">
            </form></td>
    </tr>
    </mma:products>
</table>
        
</body>
</html>