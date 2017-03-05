<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>




<div class="row">
	<div class="col-md-offset-4 col-md-3">
		<form:form class="form-horizontal" action="/admin/countryModer"
			method="POST" modelAttribute="country">
			<label for="saveCountry"><form:errors path="name"/></label><br>		
			<label for="saveCountry">Add Country(name)</label> 
			<form:input type="text"
				class="form-control" name="saveCountry" path="name" id="saveCountry"/>
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
				<c:forEach items="${countries}" var="country">
					<tr>
						<td>${country.id}</td>
						<td>${country.name}</td>
						<td><a class="btn btn-danger"
							href="/admin/countryModer/delete/${country.id}">delete</a></td>
						<td><a class="btn btn-warning"
							href="/admin/countryModer/update/${country.id}">update</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>