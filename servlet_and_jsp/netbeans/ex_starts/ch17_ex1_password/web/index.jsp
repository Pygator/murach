<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>
    <h1>Log In</h1>
    <p><i>${message}</i></p>
    <form action="check" method="post">
        <input type="hidden" name="action" value="add">        
        <label class="pad_top">Username:</label>
        <input type="text" name="username"><br>
        <label class="pad_top">Password:</label>
        <input type="password" name="password"><br>
        <label>&nbsp;</label>
        <input type="submit" value="Log In" class="margin_left">
    </form>
    <h2>Password info</h2>
    <p>Hash:<br>${hashedPassword}</p>
    <p>Salt:<br>${salt}</p>
    <p>Salted Hash:<br>${saltedAndHashedPassword}</p>
</body>
</html>