<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="/resources/css/selector.css">




<div id="main">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2 col-md-offset-1">
				<div class="row">
					<div class="col-md-12" id="leftselector">
						<p id="selections">Розділи</p>
						<c:forEach items="${categories}" var="category">
							<p>
								<a href="/category/${category.id}">${category.name}</a>
							</p>
						</c:forEach>
						<p>
							<a href="">Палатки</a>
						</p>
					</div>
				</div>
			</div>
			<div class="col-md-4 col-md-offset-1">
				<div class="row">
					<c:forEach items="${userCommodities}" var="userCommodity">
						<p>${userCommodity.user.name} ---
							${userCommodity.commodity.name} .Number = ${userCommodity.number} </p>
					</c:forEach>
					<c:if test="${empty userCommodities}">
						<h3>Basket is empty</h3>
					</c:if>
				</div>
			</div>
			<div class="col-md-2 col-md-offset-1" id="rightcol">
				<div class="row">
					<div class="col-md-12">
						<a href=""><img src="/images/layouts/ad.jpg" width="200"
							height="200"></a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
