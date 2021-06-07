
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<%@include file="inc/header.jsp" %>

<form:form method="POST" modelAttribute="account-register">
    username: <form:input path="username" /> <form:errors path="username" element="li" delimiter="; " cssClass="error"/> <br/> 
    fullname: <form:input path="fullname" /> <form:errors path="fullname" element="li" delimiter="; " cssClass="error"/> <br/> 
    email: <form:input path="email" /> <form:errors path="email" element="li" delimiter="; " cssClass="error"/> <br/> 
    password: <form:input path="password" /> <form:errors path="password" element="li" delimiter="; " cssClass="error"/> <br/> 
    <button name="register">Register</button>
</form:form>
<c:forEach items="${error}" var="err">
    <span class="error">
        ${err}
    </span><br/>
</c:forEach>
<c:if test="${success}">
    <span>Đăng kí thành công!</span>
</c:if>
<%@include file="inc/footer.jsp" %>
