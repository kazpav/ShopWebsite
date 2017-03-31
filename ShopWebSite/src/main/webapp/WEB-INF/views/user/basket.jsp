<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="/resources/css/selector.css">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>




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
						<p>${userCommodity.user.name}--
							--- ${userCommodity.commodity.name} .Number =
							${userCommodity.number} <a class="btn btn-danger"
								href="/basket/delete/${userCommodity.id}">delete</a>
						</p>
						<p>
							<form:form class="form-horizontal" action="/basket" method="POST"
								modelAttribute="form">
								<div class="form-group">
									<p>
										<label for="number"><form:errors path="number" /></label>
									</p>
									<label for="number" class="col-sm-2 control-label">Number</label>
									<div class="col-sm-10">
										<form:input class="form-control" name="number" path="number"
											id="number" />
									</div>
								</div>
								<div class="form-group">
									<form:hidden name="user" path="user" id="user"
										value="${user.id}" />
								</div>
								<div class="form-group">
									<form:hidden name="commodity" path="commodity" id="commodity"
										value="${userCommodity.commodity.id}" />
								</div>
								<div class="form-group">
									<form:hidden name="status" id="status" path="status"
										value="${userCommodity.status}" />
								</div>
								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
										<button type="submit" class="btn btn-default">Add</button>
									</div>
								</div>
							</form:form>
						</p>
					</c:forEach>
					<c:if test="${empty userCommodities}">
						<h3>Basket is empty</h3>
					</c:if>
				</div>
				<div class="row">
					
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
