<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<link rel="stylesheet" href="/resources/css/selector.css">




<div id="main">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2 col-md-offset-1">
				<div class="row">
					<div class="col-md-12" id="leftselector">
						<p id="selections">Categories</p>
						<c:forEach items="${categories}" var="category">
							<p>
								<a href="/category/${category.id}">${category.name}</a>
							</p>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="col-md-4 col-md-offset-1">
				<div class="row">
					<div id="itemForm">
						<table>
							<tr>
								<td><img
									src="/images/commodity/${commodity.id}.jpg?version=${commodity.version}"
									height="200" width="200"></td>
								<td id="itemInfo">
									<p>
									<h3>${commodity.name}</h3>
									</p>
									<p>
										<b>Price:</b> ${commodity.price} UAH
									</p>
									<p>
										<b>Category:</b> ${commodity.category.name}
									</p>
									<p>
										<b>Subcategory:</b> ${commodity.subcategory.name}
									</p>
									<p>
										<b>Fabricator:</b> ${commodity.fabricator.name}
									</p>
									<p>
										<b>Country:</b> ${commodity.country.name}
									</p>
									<p>
										<b>Color:</b> ${commodity.color.name}
									</p>
									<p>
										<b>Quantity:</b> ${commodity.quantity}
									</p>
								</td>
							</tr>
						</table>
					</div>
				</div>
				<sec:authorize access="isAuthenticated()">
					<sec:authorize access="hasRole('ROLE_USER')">

						<div class="row">
							<div class="col-md-12 col-xs-12">
								<form:form class="form-horizontal"
									action="/commodity/${commodity.id}" method="POST"
									modelAttribute="form">
									<div class="form-group">
										<p>
											<label for="number"><form:errors path="number" /></label>
										</p>
										<label for="number" class="col-sm-2 control-label">Number</label>
										<div class="col-sm-2">
											<form:input class="form-control" name="number" path="number"
												id="number" />
										</div>
									</div>
									<div class="form-group">
										<form:hidden name="user" path="user" id="user"
											value="${user.id}" />
										<form:hidden name="commodity" path="commodity" id="commodity"
											value="${commodity.id}" />
										<form:hidden name="status" id="status" path="status"
											value="${status_inbasket}" />
									</div>
									<div class="form-group">
										<div class="col-sm-offset-2 col-sm-10">
											<button type="submit" class="btn btn-default">Add</button>
										</div>
									</div>
								</form:form>
							</div>
						</div>
					</sec:authorize>
				</sec:authorize>
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
