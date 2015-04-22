<jsp:include page="/includes/header.jsp" />
<jsp:include page="/includes/column_left_email.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section>
<h1>Join our email list</h1>
<p>If you do, we'll send you announcements about new releases and special offers.</p>

<p><i>${message}</i></p>

<form action="<c:url value='/user/subscribeToEmail'/>" method="post">
    <label>Email</label>
    <input type="email" name="email" required><br>
    <label>First Name</label>
    <input type="text" name="firstName" required><br>
    <label>Last Name</label>
    <input type="text" name="lastName" required><br>        
    <label>&nbsp;</label>
    <input type="submit" value="Join Now" id="submit">
</form>

</section>

<jsp:include page="/includes/column_right_news.jsp" />
<jsp:include page="/includes/footer.jsp" />