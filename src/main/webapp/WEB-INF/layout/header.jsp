<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>ASSINGMENT SPRING BOOT JAVA 5</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" >
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">        <link rel="stylesheet" href="/assets/css/css.css"/>
    </head>
    <body class="container">
        <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #e3f2fd">
            <a class="navbar-brand" href="/">J5Phone</a>
            <div class=" navbar-collapse">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <c:if test="${countShoppingCart>0}">
                        <li class="nav-item">
                            <a class="nav-link" href="/shopping-cart" style="color: red"><i class="bi bi-cart2"></i> Cart ${countShoppingCart}</a> 
                        </li>
                    </c:if>
                    <c:if test="${account.role==true}">
                        <li class="nav-item">
                            <a class="nav-link" href="/admin/category-manager" ><i class="bi bi-bookmark-check"></i> CategoryMNG</a> 
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/admin/product-manager" ><i class="bi bi-bookmark-heart"></i> ProductMNG</a> 
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/admin/account-manager" ><i class="bi bi-people"></i> AccountMNG</a> 
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/admin/analysis-manager" ><i class="bi bi-clipboard-data"></i> AnalysisMNG</a> 
                        </li>
                    </c:if>
                    <c:if test="${account == null}">
                        <li class="nav-item">
                            <a class="nav-link" href="/login" ><i class="bi bi-box-arrow-in-left"></i> Đăng nhập</a> 
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/register" ><i class="bi bi-person-plus-fill"></i> Đăng kí</a> 
                        </li>   
                    </c:if>
                    <c:if test="${account != null}">
                        <li class="nav-item">
                            <a class="nav-link" href="/list-order"><i class="bi bi-card-checklist"></i> Đơn hàng</a> 
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/account" ><i class="bi bi-person-circle"></i> Tài khoản</a> 
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/logout"><i class="bi bi-box-arrow-right"></i> Đăng xuất</a> 
                        </li>
                    </c:if>
                </ul>
            </div>
        </nav>    
        <div style="padding: 20px 0">
