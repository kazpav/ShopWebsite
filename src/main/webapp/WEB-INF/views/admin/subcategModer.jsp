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
			<form:form class="form-horizontal" action="/admin/subcategModer"
				method="POST" modelAttribute="subcategory">
				<label for="saveSubcategory"><form:errors path="name" /></label>
				<br>
				<label for="saveSubcategory">Add subcategory(name)</label>
				<form:input type="text" class="form-control" name="saveSubcategory"
					path="name" id="saveSubcategory" />
				<form:select path="category" class="form-control"
					items="${categories}" itemValue="id" itemLabel="name" />
				<button type="submit">Add</button>
			</form:form>
		</div>
	</div>


	<div class="row">
		<div class="col-md-2 col-xs-12">
			<form:form class="form-horizontal filter"
				action="/admin/subcategModer" method="GET" modelAttribute="filter">
				<custom:hiddenInputs
					excludeParams="search, categoryId, _categoryId" />
				<div class="form-group">
					<div class="col-sm-6">
						<form:input path="search" class="form-control" placeholder="Search" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-12">Category</label>
					<div class="col-sm-12">
						<form:checkboxes element="div" items="${categories}"
							itemValue="id" itemLabel="name" path="categoryId" />
					</div>
				</div>
				<button type="submit" class="btn btn-primary">Ok</button>
			</form:form>
		</div>
		<div class="col-md-offset-1 col-md-4">
			<table class="table">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Category</th>
						<th>Delete</th>
						<th>Update</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${page.content}" var="subcategory">
						<tr>
							<td>${subcategory.id}</td>
							<td>${subcategory.name}</td>
							<td>${subcategory.category.name}<c:if
									test="${empty subcategory.category}">
								Empty
							</c:if>
							</td>
							<td><a class="btn btn-danger"
								href="/admin/subcategModer/delete/${subcategory.id}">delete</a></td>
							<td><a class="btn btn-warning"
								href="/admin/subcategModer/update/${subcategory.id}">update</a></td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col-md-2 col-md-offset-2 col-xs-12">
			<div class="row">
				<div class="col-md-6 col-xs-6 text-center">
					<div class="dropdown">
						<button class="btn btn-primary dropdown-toggle" type="button"
							data-toggle="dropdown">
							Sort <span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
							
							<custom:sort innerHtml="Name asc"
								paramValue="name" />
							<custom:sort innerHtml="Name desc"
								paramValue="name,desc" />
							<custom:sort innerHtml="Category name asc"
								paramValue="category.name" />
							<custom:sort innerHtml="Category name desc"
								paramValue="category.name,desc" />
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