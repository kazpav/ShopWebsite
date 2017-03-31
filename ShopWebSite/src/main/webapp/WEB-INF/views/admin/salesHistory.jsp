<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${userCommodities}" var="userCommodity">
	<p>${userCommodity.commodity.name}--
		${userCommodity.purchaseContact.fullName} -- ${userCommodity.number}--${userCommodity.purchaseContact.date}</p>
</c:forEach>