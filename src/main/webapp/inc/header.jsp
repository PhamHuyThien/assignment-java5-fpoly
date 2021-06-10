<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>ASSINGMENT SPRING BOOT JAVA 5</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" >
        <link rel="stylesheet" href="/assets/css/css.css"/>
    </head>
    <body class="container">
        <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #e3f2fd">
            <a class="navbar-brand" href="/">ASSINGMENT SPRING BOOT JAVA 5</a>
            <div class=" navbar-collapse">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <c:if test="${countShoppingCart>0}">
                        <li class="nav-item">
                            <a class="nav-link" href="/shopping-cart" style="color: red"> Shopping cart ${countShoppingCart}</a> 
                        </li>
                    </c:if>
                    <c:if test="${account.role}">
                        <li class="nav-item">
                            <a class="nav-link" href="/admin/category-manager" > Quản lý mặt hàng</a> 
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/admin/product-manager" > Quản lý sản phẩm</a> 
                        </li>
                    </c:if>
                    <c:if test="${account == null}">
                        <li class="nav-item">
                            <a class="nav-link" href="/login" > Đăng nhập</a> 
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/register" > Đăng kí</a> 
                        </li>   
                    </c:if>
                    <c:if test="${account != null}">
                        <li class="nav-item">
                            <a class="nav-link" href="/list-order">Đơn hàng</a> 
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/logout"> Đăng xuất</a> 
                        </li>
                    </c:if>
                </ul>
            </div>
        </nav>    
        <div style="padding: 20px 0">
