<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<div class="row">
	<div class="col-md-offset-4 col-md-3">
		<form:form class="form-horizontal" action="/admin/colorModer"
			method="POST" modelAttribute="color">
			<label for="saveColor"><form:errors path="name" /></label><br>
			<label for="saveColor">Add color(name)</label>
			<form:input type="text" class="form-control" name="saveColor"
				path="name" id="saveColor" />
			<button type="submit">Add</button>
		</form:form>
	</div>
</div>

<div class="row">
	<div class="col-md-offset-4 col-md-3">
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Delete</th>
					<th>Update</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${colors}" var="color">
					<tr>
						<td>${color.id}</td>
						<td>${color.name}</td>
						<td><a class="btn btn-danger"
							href="/admin/colorModer/delete/${color.id}">delete</a></td>
						<td><a class="btn btn-warning"
							href="/admin/colorModer/update/${color.id}">update</a></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>