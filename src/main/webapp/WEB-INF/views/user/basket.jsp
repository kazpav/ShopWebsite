<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="/resources/css/selector.css">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" href="/resources/css/basket.css">




<div id="main">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2 col-md-offset-1">
				
			</div>
			<div class="col-md-4 col-md-offset-1">
				<div class="row">
					<div class="form">
					<c:forEach items="${userCommodities}" var="userCommodity">
						<p>
							<b>Name:</b> ${userCommodity.commodity.name}
						</p>
						<p>
							<img
								src="/images/commodity/${userCommodity.commodity.id}.jpg?version=${commodity.version}"
								height="200" width="200">
						</p>
						<p>
							<b>Number:</b> ${userCommodity.number}
						</p>
						<p>
							<form:form class="form-horizontal" action="/basket" method="POST"
								modelAttribute="form">
								<div class="form-group">
									<label for="number"><form:errors path="number" /></label> <label
										for="number" class="col-sm-2 control-label">Change
										quantity</label>
									<div class="col-sm-2">
										<form:input class="form-control" name="number" path="number"
											id="number" />
										
									</div>
								</div>
								<div class="form-group">
									<form:hidden name="user" path="user" id="user"
										value="${user.id}" />
								
									<form:hidden name="commodity" path="commodity" id="commodity"
										value="${userCommodity.commodity.id}" />
							
									<form:hidden name="status" id="status" path="status"
										value="${userCommodity.status}" />
								</div>
								<div class="form-group">
									<div class="col-sm-10">
										<button type="submit" class="btn btn-default">Change</button>
										<a class="btn btn-danger"
											href="/basket/delete/${userCommodity.id}">delete</a>
									</div>
								</div>
							</form:form>
						</p>
					</c:forEach>
					</div>
					<c:if test="${empty userCommodities}">
						<h3>Basket is empty</h3>
					</c:if>
				</div>
				<div class="row">
					<c:if test="${!empty userCommodities}">
						<p><h3><b>Summary cost is:</b> ${summaryCost} UAH</h3></p>
						<a class="btn btn-default" href="/confirmpurchase">Confirm
							purchase</a>
					</c:if>
				</div>
			</div>
			<div class="col-md-2 col-md-offset-1" id="rightcol">
				<div class="row">
					<div class="col-md-12">
						<a href=""><img src="/images/layouts/ad.jpg" width="250"
							height="250"></a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
