<jsp:include page="/includes/header.jsp" />
<jsp:include page="/includes/column_left_admin.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- begin middle column -->

<section>

<h1>${param.reportTitle}</h1>
<p>Please enter dates using this format: yyyy-mm-dd.</p>

<form action="<c:url value='/adminController/displayReport'/>" method="post">

<!-- Note the use of hidden fields to pass parameters -->
<input type="hidden" name="reportName" value="${param.reportName}">
<input type="hidden" name="reportTitle" value="${param.reportTitle}">

    <label>Start Date</label>
    <input type="text" size="10" maxlength=10 
           name="startDate" value="${currentYear}-01-01" required><br>

    <label>End Date</label>
    <input type="text" size="10" maxlength=10 
           name="endDate" value="${currentYear}-12-31" required><br>

    <label>&nbsp;</label>
    <input type="submit" value="Continue">

</form>

</section>

<!-- end middle column -->

<jsp:include page="/includes/footer.jsp" />