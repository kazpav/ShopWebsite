<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:forEach items="${userCommodities}" var="userCommodity">
	<p>${userCommodity.commodity.name} -- ${userCommodity.purchaseContact.fullName}
	 -- ${userCommodity.number} --
	 <a class="btn btn-danger"	href="/admin/currentPurchases/delete/${userCommodity.id}">Delete</a>
	 <a class="btn btn-danger" href="/admin/currentPurchases/confirmsale/${userCommodity.id}">Confirm</a></p>
</c:forEach>