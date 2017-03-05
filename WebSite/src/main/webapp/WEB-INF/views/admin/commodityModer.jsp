<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<div class="row">
	<div class="col-md-offset-2 col-md-5">
		<form:form class="form-horizontal" action="/admin/commodityModer"
			method="POST" modelAttribute="commodity">
			<label for="name"><form:errors path="name"/></label><br>	
			<label for="name">Name</label>
			<form:input type="text" class="form-control" name="name" id="name" path="name"/> 
			<label for="price"><form:errors path="price"/></label><br>				
			<label for="price">Price</label> 
			<form:input type="text" class="form-control" name="price" id="price" path="price"/>
			<label for="description"><form:errors path="description"/></label><br>	 
			<label for="description">Description</label>
			<form:input type="text" class="form-control" name="description"
				id="description" path="description"/>
			<label for="subcategory">Subcategory</label>
			<form:select class="form-control" name="subcategory" path="subcategory"
				id="subcategory" items="${subcategories}" itemValue="id" itemLabel="name"/>
			<label for="color">Color</label>
			<form:select class="form-control" name="color" path="color"
				id="color" items="${colors}" itemValue="id" itemLabel="name"/>
			<label for="country">Country</label>
			<form:select class="form-control" name="country" path="country"
				id="country" items="${countries}" itemValue="id" itemLabel="name"/>
			<label for="fabricator">Fabricator</label>
			<form:select class="form-control" name="fabricator" path="fabricator"
				id="fabricator" items="${fabricators}" itemValue="id" itemLabel="name"/>
			<button type="submit">Add</button>
		</form:form>
	</div>
</div>





<div class="row">
	<div class="col-md-offset-2 col-md-7">
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
					<th>SellQuantity</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${commodities}" var="commodity">
					<tr>
						<td>${commodity.id}</td>
						<td>${commodity.name}</td>
						<td>${commodity.price }</td>
						<td><a class="btn btn-danger"
							href="/admin/commodityModer/delete/${commodity.id}">delete</a>
						</td>
						<td><a class="btn btn-warning"
							href="/admin/commodityModer/update/${commodity.id}">update</a>
						
						
						</td>
						<td>${commodity.category}<c:if
								test="${empty commodity.category}">
								Empty
							</c:if>
						</td>
						<td>${commodity.subcategory}<c:if
								test="${empty commodity.subcategory}">
								Empty
							</c:if>
						</td>
						<td>${commodity.color}<c:if test="${empty commodity.color}">
								Empty
							</c:if>
						</td>
						<td>${commodity.country}<c:if
								test="${empty commodity.country}">
								Empty
							</c:if>
						</td>
						<td>${commodity.fabricator}<c:if
								test="${empty commodity.fabricator}">
								Empty
							</c:if>
						</td>
						<td>${commodity.description}</td>
						<td>${commodity.sellQuantity}</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

