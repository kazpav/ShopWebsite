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
					<th>Phone number</th>
					<th>Address</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${userCommodities}" var="userCommodity">
					<tr>
						<td><a href="/commodity/${userCommodity.commodity.id}">${userCommodity.commodity.name}</a></td>
						<td>${userCommodity.number}</td>
						<td>${userCommodity.purchaseContact.fullName}</td>
						<td>${userCommodity.purchaseContact.contactNumber}</td>
						<td>${userCommodity.purchaseContact.address}</td>
						<td><a class="btn btn-danger"
								href="/admin/currentPurchases/delete/${userCommodity.id}">Delete</a>
							<a class="btn btn-primary" href="/admin/currentPurchases/confirmsale/${userCommodity.id}">Confirm</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>