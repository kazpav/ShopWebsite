<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>



<div class="row">
	<div class="row">
		<div class="col-md-3 col-xs-12">
				<form:form class="form-inline" action="/admin/fabricatorModer" method="GET" modelAttribute="filter">
				<custom:hiddenInputs excludeParams="search"/>
				<div class="form-group">
					<form:input path="search" class="form-control" placeholder="Search"/>
				</div>
				<button class="btn btn-primary" type="submit">Ok</button>
			</form:form>
		</div>
	</div>

	<div class="row">
		<div class="col-md-offset-4 col-md-3">
			<form:form class="form-horizontal" action="/admin/fabricatorModer"
				method="POST" modelAttribute="fabricator">
				<label for="saveFabricator"><form:errors path="name"/></label><br>		
				<label for="saveFabricator">Add fabricator(name)</label> 
				<form:input type="text"
					class="form-control" name="saveFabricator" path="name" id="saveFabricator"/>
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
					<c:forEach items="${page.content}" var="fabricator">
						<tr>
							<td>${fabricator.id}</td>
							<td>${fabricator.name}</td>
							<td><a class="btn btn-danger"
								href="/admin/fabricatorModer/delete/${fabricator.id}">delete</a></td>
							<td><a class="btn btn-warning"
								href="/admin/fabricatorModer/update/${fabricator.id}">update</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
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
							<custom:sort innerHtml="Name asc" paramValue="name" />
							<custom:sort innerHtml="Name desc" paramValue="name,desc" />
						</ul>
					</div>
				</div>
				<div class="col-md-6 col-xs-6 text-center">
					<custom:size posibleSizes="1,2,5,10" size="${page.size}" />
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
