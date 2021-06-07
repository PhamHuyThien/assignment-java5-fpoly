
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  

<%@include file="inc/header.jsp" %>

<a href="/shopping-cart">check cart</a>
<div class="row">
    <c:forEach items="${listCategories}" var="category">
        <div class="row">
            <div class="row">
                <h3>${category.name.toUpperCase()}</h3>
            </div>
            <div class="row">
                <c:forEach items="${category.listProducts}" var="product">
                    <div class="col-3 text-center border border-primary">
                        <img class="img-fluid" src="${product.image}"/>
                        <h4>${product.name.toUpperCase()}</h4>
                        <p>Giá ${product.price} tr VND </p>
                        <button type="button" onclick="window.location.href='/cart/add/${product.id}'" class="btn btn-primary btn-sm">Thêm vào giỏ hàng</button>
                    </div>
                </c:forEach>
            </div>
        </div>
    </c:forEach>   
</div>

<%@include file="inc/footer.jsp" %>
