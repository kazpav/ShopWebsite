<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<div class="row">
	<div class="col-md-5 col-md-offset-2">
		<form class="form-horizontal" action="/registration", method="POST"">
			<div class="form-group">
				<label class="control-label col-md-2" for="name">Ім'я</label>
				<div class="col-md-10">
					<input id="name" class="form-control" name="name">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-2" for="country">Країна</label>
				<div class="col-md-10">
					<input id="country" class="form-control" name="country">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-2" for="email">Ел. пошта</label>
				<div class="col-md-10">
					<input id="email" class="form-control" name="email">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-2" for="pass">Пароль</label>
				<div class="col-md-10">
					<input id="pass" class="form-control" type="password" name="password">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-2" for="city">Місто</label>
				<div class="col-md-10">
					<input id="city" class="form-control" name="city">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-2" for="country">Ваша
					область</label>
				<div class="col-md-10">
					<select id="country" class="form-control">
						<option>Київська</option>
						<option>Львівська</option>
						<option>Одеська</option>
						<option>Дніпропетровська</option>
						<option>Харківська</option>
						<option>Житомирська</option>
					</select>
					<p class="help-block">Оберіть вашу область</p>
				</div>
			</div>
			<div class="form-group">
				<div class="col-md-10 col-md-offset-2">
					<div class="checkbox">
						<label> <input type="checkbox"> Я погоджуюсь з
							правилами використання ресурсу
						</label>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-md-10 col-md-offset-2">
					<button type="submit" class="btn btn-primary">Реєстрація</button>
				</div>
			</div>
		</form>
	</div>
	<div class="col-md-2 col-md-offset-2" id="rightcol">
		<div class="row">
			<div class="col-md-12">
				<a href=""><img src="images/ad.jpg" width="300" height="auto"></a>
			</div>
		</div>
	</div>
</div>
