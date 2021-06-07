
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<%@include file="inc/header.jsp" %>

<form:form method="POST" modelAttribute="account-login">
    username: <form:input path="username" /> <form:errors path="username" element="li" delimiter="; " cssClass="error"/> <br/> 
    password: <form:password path="password" /> <form:errors path="password" element="li" delimiter="; " cssClass="error"/> <br/> 
    <button name="login">Login</button>
</form:form>
<c:forEach items="${error}" var="err">
    <span class="error">
        ${err}
    </span><br/>
</c:forEach>
<%@include file="inc/footer.jsp" %>
