<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="row">
	<div class="col-sm-12 col-xs-12">
		<form:form class="form-horizontal" action="/registration" method="POST" modelAttribute="user">
  			<div class="form-group">
				<label for="name" class="col-sm-offset-4 col-sm-5"><form:errors path="name"/></label>
			</div>
  			<div class="form-group">
    			<label for="name" class="col-sm-2 col-sm-offset-2 control-label">Name</label>
    			<div class="col-sm-4">
      				<form:input class="form-control" path="name" id="name"/>
    			</div>
  			</div>
  			<div class="form-group">
				<label for="email" class="col-sm-offset-4 col-sm-5"><form:errors path="email"/></label>
			</div>
			<div class="form-group">
    			<label for="email" class="col-sm-2 col-sm-offset-2 control-label">Email</label>
    			<div class="col-sm-4">
      				<form:input class="form-control" path="email" id="email"/>
    			</div>
  			</div>
  			<div class="form-group">
				<label for="email" class="col-sm-offset-4 col-sm-5"><form:errors path="password"/></label>
			</div>
			<div class="form-group">
    			<label for="password" class="col-sm-2 col-sm-offset-2 control-label">Password</label>
    			<div class="col-sm-4">
      				<form:password class="form-control" path="password" id="password"/>
    			</div>
  			</div>
  			<div class="form-group">
  				<label for="repeatPassword" class="col-sm-2 col-sm-offset-2 control-label">Repeat password</label>
    			<div class="col-sm-4">
      				<form:password class="form-control" path="repeatPassword" id="repeatPassword"/>
    			</div>
  			</div>
  			<div class="form-group">
    			<div class="col-sm-offset-4 col-sm-10">
      				<button type="submit" class="btn btn-default">Register</button>
    			</div>
  			</div>
		</form:form>
	</div>
</div>