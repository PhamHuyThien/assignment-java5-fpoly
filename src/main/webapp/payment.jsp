
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<%@include file="inc/header.jsp" %>

<div>
    <div class="row">
        <h4>Danh sách sản phẩm</h4>
    </div>
    <c:forEach items="${listCarts}" var="cart">
        <div class="row">
            <div class="col-4">
                ${cart.value.name}
            </div>
            <div class="col-4">
                x${cart.value.qty}
            </div>
            <div class="col-4">
                ${cart.value.price * cart.value.qty} tr VND
            </div>
        </div>
    </c:forEach>
    <div class="row">
        <div class="col-4">
            Tổng tiền:
        </div>
        <div class="col-4">
        </div>
        <div class="col-4">
           ${totalPayment} tr VND
        </div>
    </div>
</div>
<div>
    <div class="row">
        <h4>Xác nhận đơn hàng</h4>
    </div>
    <form:form action="/payment/add" method="POST" modelAttribute="paymentForm">
        <div class="form-group">
            <label for="">Họ và tên nhận hàng:</label>
            <form:input path="name" cssClass="form-control" id="" placeholder="Enter name"/>
            <form:errors path="name" element="li" delimiter="; " cssClass="error"/> 
        </div>
        <div class="form-group">
            <label for="">Số điện thoại:</label>
            <form:input  path="phone" cssClass="form-control" id="" placeholder="Enter Phonenumber"/>
            <form:errors path="phone" element="li" delimiter="; " cssClass="error"/> 
        </div>
        <div class="form-group">
            <label for="">Địa chỉ nhận hàng:</label>
            <form:input path="andress" class="form-control" id="" placeholder="Enter andress"/>
            <form:errors path="andress" element="li" delimiter="; " cssClass="error"/> 
        </div>
        <div class="form-group form-check">
            <input type="checkbox" class="form-check-input" id="">
            <label class="form-check-label" for="exampleCheck1">Thanh toán khi nhận hàng</label>
        </div>
        <div class="text-center">
            <button type="submit" class="btn btn-primary">Đặt hàng</button>
        </div>
    </form:form>
</div>
<script>
    let pathName = window.location.pathname;
    if(!pathName.endsWith("payment") && !pathName.endsWith("payment/")){
        setInterval(function(){
            window.location.href = "";
        }, 3000);
    }
</script>
<%@include file="inc/footer.jsp" %>
