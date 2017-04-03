<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<link rel="stylesheet" href="/resources/css/selector.css">
<link rel="stylesheet" href="/resources/css/itemForm.css">
<link rel="stylesheet" href="/resources/css/search.css">

<script type="text/javascript" src="/resources/js/spoiler.js"></script>
<style type="text/css">
.spoiler_body {
	display: none;
}

.spoiler_links {
	cursor: pointer;
}
</style>



<style>
.filter .control-label {
	text-align: left;
}
</style>


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
					<div class="col-md-12">
						<form:form class="form-horizontal filter" action="/search"
							method="GET" modelAttribute="searchFilter">
							<custom:hiddenInputs
								excludeParams="nameSearch, min, max, countryId, colorId, subcategoryID, categoryId, fabricatorID,
					 _countryId, _colorId, _subcategoryID, _categoryId, _fabricatorID" />
							<div class="form-group">
								<div class="col-sm-6">
									<form:input path="nameSearch" class="form-control"
										placeholder="Name" />
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-6">
									<form:input path="min" class="form-control" placeholder="Min" />
								</div>
								<div class="col-sm-6">
									<form:input path="max" class="form-control" placeholder="Max" />
								</div>
							</div>
							<div class="row">
								<div class="col-sm-5 col-sm-offset-1">
									<div class="form-group">
										<div>
											<a href="" class="spoiler_links"><label
												class="control-label">Country &#8595</label></a>
											<div class="spoiler_body">
												<form:checkboxes element="div" items="${countries}"
													itemValue="id" itemLabel="name" path="countryId" />
											</div>
										</div>
									</div>
								</div>
								<div class="col-sm-5 col-sm-offset-1">
									<div class="form-group">
										<div>
											<a href="" class="spoiler_links"><label
												class="control-label">Color &#8595</label></a>
											<div class="spoiler_body">
												<form:checkboxes element="div" items="${colors}"
													itemValue="id" itemLabel="name" path="colorId" />
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-5 col-sm-offset-1">
									<div class="form-group">
										<div>
											<a href="" class="spoiler_links"><label
												class="control-label">Subcategory &#8595</label></a>
											<div class="spoiler_body">
												<form:checkboxes element="div" items="${subcategories}"
													itemValue="id" itemLabel="name" path="subcategoryId" />
											</div>
										</div>
									</div>
								</div>
								<div class="col-sm-5 col-sm-offset-1">
									<div class="form-group">
										<div>
											<a href="" class="spoiler_links"> <label
												class="control-label">Category &#8595</label></a>
											<div class="spoiler_body">
												<form:checkboxes element="div" items="${categories}"
													itemValue="id" itemLabel="name" path="categoryId" />
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-5 col-sm-offset-1">
									<div class="form-group">
										<div>
											<a href="" class="spoiler_links"> <label
												class="control-label">Fabricator &#8595</label></a>
											<div class="spoiler_body">
												<form:checkboxes element="div" items="${fabricators}"
													itemValue="id" itemLabel="name" path="fabricatorId" />
											</div>
										</div>
									</div>
								</div>
								<div class="col-sm-5 col-sm-offset-1">
									<button type="submit" class="btn btn-primary">Ok</button>
								</div>
							</div>
						</form:form>
					</div>
				</div>
				<div class="row" id="buttonpannel">
					<div class="col-md-4 col-xs-4 text-center">
						<div class="dropdown">
							<button class="btn btn-primary dropdown-toggle" type="button"
								data-toggle="dropdown">
								Sort <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<custom:sort innerHtml="Default" paramValue="id" />
								<custom:sort innerHtml="Name ascending" paramValue="name" />
								<custom:sort innerHtml="Name descending" paramValue="price,desc" />
								<custom:sort innerHtml="Price ascending" paramValue="price" />
								<custom:sort innerHtml="Price descending"
									paramValue="price,desc" />
							</ul>
						</div>
					</div>
					<div class="col-md-4 col-xs-4 text-center">
						<custom:size posibleSizes="1,2,5,10" size="${page.size}" />
					</div>
					<div class="col-md-4 col-xs-4 text-center">
						<a href="/search"><button class="btn btn-primary">Clear</button></a>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<c:forEach items="${page.content}" var="commodity">
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
					</div>
				</div>
				<div class="row">
					<div class="row">
						<div class="col-md-12 col-xs-12 text-center">
							<custom:pageable page="${page}" cell="<li></li>"
								container="<ul class='pagination'></ul>" />
						</div>
					</div>
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
