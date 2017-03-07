<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


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
	<div class="col-md-offset-3 col-md-4">
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
				<c:forEach items="${subcategories}" var="subcategory">
					<tr>
						<td>${subcategory.id}</td>
						<td>${subcategory.name}</td>
						<td>${subcategory.category}<c:if
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
</div>