<jsp:include page="/includes/header.jsp" />
<jsp:include page="/includes/column_left_all.jsp" />

<!-- start the middle column -->

<section>

  <h1>Download registration</h1>

  <p>Before you can download and listen to these sound files, 
  you must register with us by entering your name and email 
  address below.</p>

  <!-- Import the core JSTL library -->
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <!-- Use the JSTL url tag to encode the URL -->
  <form action="<c:url value='/catalog/product/${product.code}/listen/register'/>" method="post">
    <label>Email</label>
    <input type="email" name="email" required><br>
    <label>First Name</label>
    <input type="text" name="firstName" required><br>
    <label>Last Name</label>
    <input type="text" name="lastName" required><br>        
    <label>&nbsp;</label>
    <input type="submit" value="Register" id="submit">
  </form>

</section>

<!-- end the middle column -->

<jsp:include page="/includes/column_right_buttons.jsp" />
<jsp:include page="/includes/footer.jsp" />