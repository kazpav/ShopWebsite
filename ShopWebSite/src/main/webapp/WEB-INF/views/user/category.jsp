<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="/resources/css/selector.css">
<link rel="stylesheet" href="/resources/css/itemForm.css">


<div id="main">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2 col-md-offset-1">
				<div class="row">
					<div class="col-md-12" id="leftselector">
						<p id="selections">Categories</p>
						<c:forEach items="${categories}" var="category">
							<a href="/category/${category.id}"><p>${category.name}</p> </a>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="col-md-4 col-md-offset-1">
				<h2>Category: ${category.name}</h2>
				<c:forEach items="${commodities}" var="commodity">
					<div id="itemForm">
						<table>
							<tr>
								<td><img
									src="/images/commodity/${commodity.id}.jpg?version=${commodity.version}"
									height="200" width="200"></td>
								<td id="itemInfo">
									<p>
									<h3>
										<a href="/commodity/${commodity.id}">${commodity.name}</a>
									</h3>
									</p>
									<p>
										<b>Price:</b> ${commodity.price}
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
								</td>
							</tr>
						</table>
					</div>
				</c:forEach>
				<c:if test="${empty commodities}">
					<h3>Category is empty</h3>
				</c:if>
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
