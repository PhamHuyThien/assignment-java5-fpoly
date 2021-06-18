
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<div class="row justify-content-md-center">
    <div class="col-6">
        <form:form method="POST" modelAttribute="account-login">
            <div class="form-group">
                <label for="exampleInputEmail1">Username:</label>
                <form:input path="username" cssClass="form-control"/> <form:errors path="username" element="li" delimiter="; " cssClass="error"/>
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">Password:</label>
                <form:password path="password" cssClass="form-control"/> <form:errors path="password" element="li" delimiter="; " cssClass="error"/> 
            </div>
            <div class="form-check">
                <input type="checkbox" class="form-check-input" name="remember-me" id="remember-me">
                <label class="form-check-label" id="title-remember-me">Ghi nhớ mật khẩu đăng nhập.</label>
            </div><br/>
            <div class="text-center">
                <button type="submit" class="btn btn-primary">Login</button>
            </div>
        </form:form> 
    </div>
</div>
<script>
    $("#title-remember-me").click(function(){
        let checked = $("#remember-me").attr("checked");
        if(checked!=="checked"){
            $("#remember-me").attr("checked", "checked");
        }else{
            $("#remember-me").removeAttr("checked");
        }
    });
</script>

<br/>
<c:forEach items="${error}" var="err">
    <div class="alert alert-danger" role="alert">
        ${err}
    </div>
</c:forEach>
