<jsp:include page="/includes/header.jsp" />
<jsp:include page="/includes/column_left_admin.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- begin middle column -->

<section id="admin">

<h1>Report list</h1>

<p>This page contains a list of the reports that are 
    available from this site.</p>
    
<form action="<c:url value='/adminController/displayReport'/>" method="post">
    <input type="hidden" name="reportName" value="userEmail">
    <input type="hidden" name="reportTitle" value="The User Email report">
    <input type="submit" value="User Email Report" class="left_margin">
</form>

<form action="parameters.jsp" method="post">
    <input type="hidden" name="reportName" value="downloadDetail">
    <input type="hidden" name="reportTitle" value="The Downloads report">
    <input type="submit" value="Downloads report" class="left_margin">
</form>

</section>

<!-- end middle column -->

<jsp:include page="/includes/footer.jsp" />