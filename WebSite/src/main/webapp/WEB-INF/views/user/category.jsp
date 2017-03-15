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
			<div class="col-md-4 ">
				<h2>Category: ${category.name}</h2>
				<c:forEach items="${commodities}" var="commodity">
					<div>${commodity.name}${commodity.price}</div>
				</c:forEach>
				<c:if test="${empty commodities}">
					<h3>Category is empty</h3>
				</c:if>

			</div>
			<div class="col-md-2 col-md-offset-2" id="rightcol">
				<div class="row">
					<div class="col-md-12">
						<a href=""><img src="/images/layouts/ad.jpg" width="300"
							height="auto"></a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
