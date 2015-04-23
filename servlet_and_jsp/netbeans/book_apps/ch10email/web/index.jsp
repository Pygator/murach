<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>
    <h1>Join our email list</h1>
    <p>To join our email list, enter your name and
       email address below.</p>
    
    <%@ taglib prefix="mma" uri="/WEB-INF/murach.tld" %>
    <p><mma:ifEmptyMark color="blue" field=""/> marks required fields</p>
    
    <form action="emailList" method="post">
        <input type="hidden" name="action" value="add">        

        <label class="pad_top">Email:</label>
        <input type="email" name="email" value="${user.email}">
        <mma:ifEmptyMark color="blue" field="${user.email}"/><br>

        <label class="pad_top">First Name:</label>
        <input type="text" name="firstName" value="${user.firstName}">
        <mma:ifEmptyMark color="blue" field="${user.firstName}"/><br>

        <label class="pad_top">Last Name:</label>
        <input type="text" name="lastName" value="${user.lastName}">
        <mma:ifEmptyMark color="blue" field="${user.lastName}"/><br>        

        <label>&nbsp;</label>
        <input type="submit" value="Join Now" class="margin_left">
    </form>
        
    <p>The current date is <mma:currentDate />.</p>
    
    <mma:ifWeekday>
       <p>Live support available at 1-800-555-2222</p>
    </mma:ifWeekday>
    
</body>
</html>