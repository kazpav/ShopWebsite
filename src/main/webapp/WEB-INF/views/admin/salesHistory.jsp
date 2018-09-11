<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container-fluid">
	<div class="row">
		<table class="table">
			<thead>
			<tr>
				<th>Commodity</th>
				<th>Quantity</th>
				<th>Customer</th>
				<th>Date</th>
			</tr>
			</thead>
			<tbody>
				<c:forEach items="${userCommodities}" var="userCommodity">
					<tr>
						<td>${userCommodity.commodity.name}</td>
						<td>${userCommodity.number}</td>
						<td>${userCommodity.purchaseContact.fullName}</td>
						<td>${userCommodity.purchaseContact.date}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>