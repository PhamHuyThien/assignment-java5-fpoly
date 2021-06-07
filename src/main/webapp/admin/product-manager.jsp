
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<%@include file="../inc/header.jsp" %>

<form:form method="POST" action="/admin/product-manager/add" modelAttribute="productForm" enctype="multipart/form-data">
    <form:select path="categoryId">
        <c:forEach items="${listCategory}" var="category">
            <c:choose>
                <c:when test="${category.id == productForm.categoryId}">
                    <form:option selected="true" value="${category.id}">${category.name}</form:option>
                </c:when>
                <c:otherwise>
                    <form:option value="${category.id}">${category.name}</form:option>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </form:select><br/>
    id: <form:input path="id" /> <form:errors path="id" element="li" delimiter="; " cssClass="error"/> <br/> 
    name: <form:input path="name" /> <form:errors path="name" element="li" delimiter="; " cssClass="error"/> <br/> 
    price: <form:input path="price" /> <form:errors path="price" element="li" delimiter="; " cssClass="error"/> <br/> 
    image: <input type="file" name="avatar"><br/>
    <form:select path="status">
        <form:option value="true">Kích hoạt</form:option>
        <form:option value="false">Bỏ kích hoạt</form:option>
    </form:select><br/>
    <button name="add">Thêm</button>
    <button formaction="/admin/product-manager/delete" >Xóa</button>
</form:form>
<button onclick="window.location.href='/admin/product-manager'">Reset</button>
<c:forEach items="${error}" var="err">
    <span class="error">
        ${err}
    </span><br/>
</c:forEach>
<c:if test="${not empty success}">
    <span class="success">
        ${success}
    </span><br/>
</c:if>
<table border="1"> 
    <thead>
        <tr>
            <th><a href="?col-sort=id&type-sort=${typesort}&page=${page}">id</a></th>
            <th><a href="?col-sort=name&type-sort=${typesort}&page=${page}">name</a></th>
            <th><a href="?col-sort=price&type-sort=${typesort}&page=${page}">price</a></th>
            <th><a href="?col-sort=category&type-sort=${typesort}&page=${page}">type</a></th>
            <th><a href="?col-sort=status&type-sort=${typesort}&page=${page}">status</a></th>
            <th>action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${listProduct}" var="list">
            <tr>
                <th>${list.id}</th>
                <td>${list.name}</td>
                <td>${list.price}</td>
                <td>${list.category.name}</td>
                <td>${list.status}</td>
                <td><a href="?edit=${list.id}">Edit</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<a href="?page=${page-1}">prev</a> ${page+1}
<a href="?page=${page+1}">next</a>

<script>
    let pathName = window.location.pathname;
    if(!pathName.endsWith("product-manager/") && !pathName.endsWith("product-manager")){
        setInterval(function(){
            window.location.href = "";
        }, 3000);
    }
</script>
<%@include file="../inc/footer.jsp" %>
