<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div id="main">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2 col-md-offset-1">
				<div class="row"></div>
			</div>
			<div class="col-md-4 col-md-offset-1">
				<div class="row">
					<c:forEach items="${userCommodities}" var="userCommodity">
						<p>${userCommodity.user.name}--
							--- ${userCommodity.commodity.name} .Number =
							${userCommodity.number} <a class="btn btn-danger"
								href="/basket/delete/${userCommodity.id}">delete</a>
						</p>
					</c:forEach>
				</div>
				<div class="row">
					<form:form class="form-horizontal" action="/confirmpurchase"
						method="POST" modelAttribute="form">
						<div class="form-group">
							<label for="fullName"><form:errors path="fullName" /></label> <label
								for="fullName" class="col-sm-2 control-label">Full name</label>
							<div class="col-sm-10">
								<form:input class="form-control" name="fullName" path="fullName"
									id="fullName" />
							</div>
						</div>
						<div class="form-group">
							<label for="contactNumber"><form:errors
									path="contactNumber" /></label> <label for="contactNumber"
								class="col-sm-2 control-label">Contact number</label>
							<div class="col-sm-10">
								<form:input class="form-control" name="contactNumber"
									path="contactNumber" id="contactNumber" />
							</div>
						</div>
						<div class="form-group">
							<label for="address"><form:errors path="address" /></label> <label
								for="address" class="col-sm-2 control-label">Delivery
								adress</label>
							<div class="col-sm-10">
								<form:input class="form-control" name="address" path="address"
									id="address" />
							</div>
						</div>
						<div class="form-group">
							<form:hidden name="date" id="date" path="date" value="${date}" />
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-default">Add</button>
							</div>
						</div>
					</form:form>
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
