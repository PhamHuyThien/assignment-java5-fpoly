
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<%@include file="../inc/header.jsp" %>

<form:form method="POST" action="/admin/category-manager/add" modelAttribute="category">
    id <form:input path="id" /> <form:errors path="id" element="li" delimiter="; " cssClass="error"/> <br/> 
    name: <form:input path="name" /> <form:errors path="name" element="li" delimiter="; " cssClass="error"/> <br/> 
    <form:select path="status">
        <form:option value="true">Kích hoạt</form:option>
        <form:option value="false">Bỏ kích hoạt</form:option>
    </form:select><br/>
    <button name="add">Thêm</button>
    <button formaction="/admin/category-manager/delete" >Xóa</button>
</form:form>
<button onclick="window.location.href='/admin/category-manager'">Reset</button>
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
            <th><a href="?col-sort=status&type-sort=${typesort}&page=${page}">status</a></th>
            <th>action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${listcategory}" var="list">
            <tr>
                <th>${list.id}</th>
                <td>${list.name}</td>
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
    if(!pathName.endsWith("category-manager")){
        setInterval(function(){
            window.location.href = "";
        }, 3000);
    }
</script>
<%@include file="../inc/footer.jsp" %>
