<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>

<style>
.filter .control-label {
	text-align: left;
}
</style>

<div class="row">
	<div class="row">
		<div class="col-md-offset-3 col-md-4">
			<form:form class="form-horizontal" action="/admin/commodityModer"
				method="POST" modelAttribute="commodity">
				<label for="name"><form:errors path="name" /></label>
				<br>
				<label for="name">Name</label>
				<form:input type="text" class="form-control" name="name" id="name"
					path="name" />
				<label for="price"><form:errors path="price" /></label>
				<br>
				<label for="price">Price</label>
				<form:input type="text" class="form-control" name="price" id="price"
					path="price" />
				<label for="description"><form:errors path="description" /></label>
				<br>
				<label for="description">Description</label>
				<form:input type="text" class="form-control" name="description"
					id="description" path="description" />
				<label for="subcategory">Subcategory</label>
				<form:select class="form-control" name="subcategory"
					path="subcategory" id="subcategory" items="${subcategories}"
					itemValue="id" itemLabel="name" />
				<label for="color">Color</label>
				<form:select class="form-control" name="color" path="color"
					id="color" items="${colors}" itemValue="id" itemLabel="name" />
				<label for="country">Country</label>
				<form:select class="form-control" name="country" path="country"
					id="country" items="${countries}" itemValue="id" itemLabel="name" />
				<label for="fabricator">Fabricator</label>
				<form:select class="form-control" name="fabricator"
					path="fabricator" id="fabricator" items="${fabricators}"
					itemValue="id" itemLabel="name" />
				<button type="submit">Add</button>
			</form:form>
		</div>
	</div>






	<div class="row">
		<div class="col-md-2 col-xs-12">
			<form:form class="form-horizontal filter"
				action="/admin/commodityModer" method="GET" modelAttribute="filter">
				<custom:hiddenInputs
					excludeParams="min, max, countryId, colorId, subcategoryID, categoryId, fabricatorID,
					 _countryId, _colorId, _subcategoryID, _categoryId, _fabricatorID" />
				<div class="form-group">
					<div class="col-sm-6">
						<form:input path="nameSearch" class="form-control" placeholder="Name"/>
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
				<div class="form-group">
					<label class="control-label col-sm-12">Country</label>
					<div class="col-sm-12">
						<form:checkboxes element="div" items="${countries}" itemValue="id"
							itemLabel="name" path="countryId" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-12">Color</label>
					<div class="col-sm-12">
						<form:checkboxes element="div" items="${colors}" itemValue="id"
							itemLabel="name" path="colorId" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-12">Subcategory</label>
					<div class="col-sm-12">
						<form:checkboxes element="div" items="${subcategories}"
							itemValue="id" itemLabel="name" path="subcategoryId" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-12">Category</label>
					<div class="col-sm-12">
						<form:checkboxes element="div" items="${categories}"
							itemValue="id" itemLabel="name" path="categoryId" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-12">Fabricator</label>
					<div class="col-sm-12">
						<form:checkboxes element="div" items="${fabricators}"
							itemValue="id" itemLabel="name" path="fabricatorId" />
					</div>
				</div>
				<button type="submit" class="btn btn-primary">Ok</button>
			</form:form>
		</div>
		<div class="col-md-8">
			<table class="table">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Price</th>
						<th>Delete</th>
						<th>Update</th>
						<th>Category</th>
						<th>Subcategory</th>
						<th>Color</th>
						<th>Country</th>
						<th>Fabricator</th>
						<th>Description</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${page.content}" var="commodity">
						<tr>
							<td>${commodity.id}</td>
							<td>${commodity.name}</td>
							<td>${commodity.price }</td>
							<td><a class="btn btn-danger"
								href="/admin/commodityModer/delete/${commodity.id}">delete</a></td>
							<td><a class="btn btn-warning"
								href="/admin/commodityModer/update/${commodity.id}">update</a></td>
							<td>${commodity.category.name}<c:if
									test="${empty commodity.category}">
								Empty
							</c:if>
							</td>
							<td>${commodity.subcategory.name}<c:if
									test="${empty commodity.subcategory}">
								Empty
							</c:if>
							</td>
							<td>${commodity.color.name}<c:if test="${empty commodity.color}">
								Empty
							</c:if>
							</td>
							<td>${commodity.country.name}<c:if
									test="${empty commodity.country}">
								Empty
							</c:if>
							</td>
							<td>${commodity.fabricator.name}<c:if
									test="${empty commodity.fabricator}">
								Empty
							</c:if>
							</td>
							<td>${commodity.description}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col-md-2 col-xs-12">
			<div class="row">
				<div class="col-md-6 col-xs-6 text-center">
					<div class="dropdown">
						<button class="btn btn-primary dropdown-toggle" type="button"
							data-toggle="dropdown">
							Sort <span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
							
							<custom:sort innerHtml="Subcategory name asc"
								paramValue="subcategory.name" />
							<custom:sort innerHtml="Subcategory name desc"
								paramValue="subcategory.name,desc" />
							<custom:sort innerHtml="Category name asc"
								paramValue="category.name" />
							<custom:sort innerHtml="Category name desc"
								paramValue="category.name,desc" />
							<custom:sort innerHtml="Fabricator name asc"
								paramValue="fabricator.name" />
							<custom:sort innerHtml="Fabricator name desc"
								paramValue="fabricator.name,desc" />

						</ul>
					</div>
				</div>
				<div class="col-md-6 col-xs-6 text-center">
					<custom:size posibleSizes="1,2,5,10" size="${page.size}" />
				</div>
			</div>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-md-12 col-xs-12 text-center">
		<custom:pageable page="${page}" cell="<li></li>"
			container="<ul class='pagination'></ul>" />
	</div>
</div>
