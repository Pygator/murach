<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"> 
    <title>Vecta Corp. Mobile</title>
    <link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
    <!-- JavaScript HTML requirements -->
	<script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
	<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
</head>

<body>
<div data-role="page" id="home">
    <header data-role="header">
        <h1>Contact Us</h1>
    </header>
    
    <section class="ui-content" role="main">
    <p>Thank you for contacting Vecta Corporation. An email has been sent to 
    one of our sales representatives and you should be contacted shortly. Our
    sales representatives will attempt to contact you using the following information:</p>
	<%
    response.write("Name: " & request.form("name")) & "<br>"
    response.write("Company name: " & request.form("companyname")) & "<br>"
    response.write("Phone number: " & request.form("phone")) & "<br>"
    response.write("Email: " & request.form("email")) & "<br>"
    %>
    </section>
    
    <footer data-role="footer">
        <h4>&copy; 2016</h4>
    </footer>
</div>
</body>
</html>