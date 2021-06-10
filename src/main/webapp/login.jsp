
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<%@include file="inc/header.jsp" %>

<form:form method="POST" modelAttribute="account-login">
    <div class="form-group">
        <label for="exampleInputEmail1">Username:</label>
        <form:input path="username" cssClass="form-control"/> <form:errors path="username" element="li" delimiter="; " cssClass="error"/>
    </div>
    <div class="form-group">
        <label for="exampleInputEmail1">Password:</label>
        <form:password path="password" cssClass="form-control"/> <form:errors path="password" element="li" delimiter="; " cssClass="error"/> 
    </div>
    <div class="text-center">
        <button type="submit" class="btn btn-primary">Login</button>
    </div>
</form:form>
<br/>
<c:forEach items="${error}" var="err">
    <div class="alert alert-danger" role="alert">
        ${err}
    </div>
</c:forEach>
<%@include file="inc/footer.jsp" %>
