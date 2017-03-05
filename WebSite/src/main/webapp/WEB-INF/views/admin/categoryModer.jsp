<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<div class="row">
	<div class="col-md-offset-4 col-md-3">
		<form:form class="form-horizontal" action="/admin/categoryModer"
			method="POST" modelAttribute="category">
			<label for="saveCateg"><form:errors path="name"/></label><br>
			<label for="saveCateg">Add category(name)</label>
			<form:input type="text"
				class="form-control" name="saveCateg" path="name" id="saveCateg"/>
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
				<c:forEach items="${categories}" var="category">
					<tr>
						<td>${category.id}</td>
						<td>${category.name}</td>
						<td><a class="btn btn-danger"
							href="/admin/categoryModer/delete/${category.id}">delete</a></td>
						<td><a class="btn btn-warning" 
							href="/admin/categoryModer/update/${category.id}">update</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>





