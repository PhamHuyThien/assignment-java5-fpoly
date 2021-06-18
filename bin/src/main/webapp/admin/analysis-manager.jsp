
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


Top 10 sản phẩm bán chạy nhất:
<c:forEach items="${bigOrder}" var="reportProduct">
    <c:out value="${reportProduct.product.name}" />
</c:forEach>