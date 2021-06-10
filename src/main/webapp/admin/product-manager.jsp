
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<%@include file="../inc/header.jsp" %>

<form:form method="POST" action="/admin/product-manager/add" modelAttribute="productForm" enctype="multipart/form-data">

    <div class="form-inline">
        <label class="my-1 mr-2" for="inlineFormCustomSelectPref">Thể loại sản phẩm:</label>
        <form:select cssClass="custom-select" path="categoryId">
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
        </form:select>
    </div>
    <div class="form-group">
        <label for="exampleInputEmail1">id:</label>
        <form:input path="id" cssClass="form-control"/> <form:errors path="id" element="li" delimiter="; " cssClass="error"/> 
    </div>
    <div class="form-group">
        <label for="exampleInputEmail1">Name:</label>
        <form:input path="name" cssClass="form-control"/> <form:errors path="name" element="li" delimiter="; " cssClass="error"/>
    </div>
    <div class="form-group">
        <label for="exampleInputEmail1">Price:</label>
        <form:input path="price" cssClass="form-control" /> <form:errors path="price" element="li" delimiter="; " cssClass="error"/> 
    </div><br/>
    <div class="custom-file">
        <input type="file" name="file" class="custom-file-input" id="validatedCustomFile" required>
        <label class="custom-file-label" for="validatedCustomFile">Chọn file ảnh sản phẩm...</label>
    </div><br/><br/>
    <div class="form-inline">
        <label class="my-1 mr-2" for="inlineFormCustomSelectPref">Tình trạng:</label>
        <form:select path="status" cssClass="custom-select">
            <form:option value="true">Kích hoạt</form:option>
            <form:option value="false">Bỏ kích hoạt</form:option>
        </form:select>
    </div><br/>
    <div class="text-right">
        <button class="btn btn-primary" name="add">Thêm</button>
        <button class="btn btn-danger" formaction="/admin/product-manager/delete" >Xóa</button>
        <button class="btn btn-warning" formaction="/admin/product-manager" formmethod="get">Reset</button>
    </div><br/>
</form:form>
<c:forEach items="${error}" var="err">
    <div class="alert alert-error" role="alert">
        ${err}
    </div>
</c:forEach>
<c:if test="${not empty success}">
    <div class="alert alert-success" role="alert">
        ${success}
    </div>
</c:if>
<table class="table table-striped"> 
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
<div class="text-center">    
    <a href="?page=${page-1}">prev</a> ${page+1}
    <a href="?page=${page+1}">next</a>
</div>
<script>
    let pathName = window.location.pathname;
    if(!pathName.endsWith("product-manager/") && !pathName.endsWith("product-manager")){
        setInterval(function(){
            window.location.href = "";
        }, 3000);
    }
</script>
<%@include file="../inc/footer.jsp" %>
