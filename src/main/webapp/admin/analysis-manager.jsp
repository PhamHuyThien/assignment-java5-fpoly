
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="thiendz.j5.assignment.util.Utils"%>

<h3>Top 10 sản phẩm bán chạy nhất:</h3>
<table class="table table-striped">
	<thead>
		<tr>
			<th scope="col">#</th>
			<th scope="col">Tên sản phẩm</th>
			<th scope="col">Số lượn bán</th>
			<th scope="col">Tổng số tiền</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${bigOrder}" var="report" varStatus="loop">
			<tr>
				<th scope="row">${loop.index + 1}</th>
				<td>${report.product.name}</td>
				<td>${report.count }</td>
				<td>${Utils.numberFormatMoney(report.total)}tr VND</td>
			</tr>
		</c:forEach>
	</tbody>
</table>