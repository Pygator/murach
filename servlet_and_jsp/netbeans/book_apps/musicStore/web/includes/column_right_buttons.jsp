    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <aside id="sidebarB">
        <form method="post" action="<c:url value='/order/addItem'/>">
            <input type="hidden" name="productCode" value="${product.code}">
            <input type="image" src="<c:url value='/images/addtocart.gif'/>" 
                   width="113" alt="Add to Cart">
        </form>
        <a href="<c:url value='/catalog/product/${product.code}/listen' />">
            <img src="<c:url value='/images/listen.gif'/>" 
                 width="113" alt="Listen to Samples" class="top_margin">
        </a>
    </aside>