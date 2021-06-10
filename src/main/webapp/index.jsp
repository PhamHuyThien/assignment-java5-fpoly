
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  

<%@include file="inc/header.jsp" %>


<c:forEach items="${listCategories}" var="category">
    <div style="padding: 0 15px">
        <div class="row">
            <h3>${category.name.toUpperCase()}</h3>
        </div>
        <div class="row">
            <c:forEach items="${category.listProducts}" var="product">
                <div class="col-3 text-center" style="padding: 2px">
                    <div class="col-md-12 border border-primary" style="padding: 10px">
                        <img class="img-fluid" src="${product.image}"/>
                        <h4>${product.name.toUpperCase()}</h4>
                        <p>Giá ${product.price} tr VND </p>
                        <button type="button" onclick="window.location.href='/cart/add/${product.id}'" class="btn btn-primary btn-sm">Thêm vào giỏ hàng</button>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</c:forEach>   

<%@include file="inc/footer.jsp" %>
