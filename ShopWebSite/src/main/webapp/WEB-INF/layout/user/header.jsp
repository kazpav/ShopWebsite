<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<link rel="stylesheet" href="/resources/css/layouts.css">


<header>
	<div id="head" class="row">
		<div class="col-md-12">
			<nav class="navbar navbar-default">
				<div class="containfer-fluid">
					<div class="collapse navbar-collapse" id="one">
						<ul class="nav navbar-nav">
							<li><a href=""><img src="/images/layouts/truck.png">aОплата
									та доставка</a></li>
							<li><a href=""><img src="/images/layouts/email.png">
									Контакти</a></li>
							<li><a href=""><img src="/images/layouts/info.png">
									Допомога</a></li>
							<li><a href=""><img src="/images/layouts/phone.png">
									0 800 000 000</a></li>
						</ul>
						<ul class="nav navbar-nav navbar-right">
							<sec:authorize access="isAuthenticated()">
								<li><a>${user.name}</a></li>
							</sec:authorize>
							<sec:authorize access="!isAuthenticated()">
								<li class="dropdown"><a href="" role="button"
									class="dropdown-toggle" data-toggle="dropdown"
									aria-haspopup="true" aria-expanded="false">Sing in<span
										class="caret"></span>
								</a>
									<ul class="dropdown-menu">
										<form:form class="form-horizontal" action="/login"
											method="POST">
											<li>
												<div class="form-group">
													<label class="control-label col-md-4" for="login">Email</label>
													<div class="col-md-8">
														<input id="login" name="login" class="form-control">
													</div>
												</div>
											</li>
											<li>
												<div class="form-group">
													<label class="control-label col-md-4" for="password">Password</label>
													<div class="col-md-8">
														<input id="password" name="password" class="form-control"
															type="password">
													</div>
												</div>
											</li>
											<li>
												<div class="form-group">
													<div class="col-sm-offset-2 col-sm-10">
														<div class="checkbox">
															<label> <input name="remember-me" type="checkbox">
																Remember me
															</label>
														</div>
													</div>
												</div>
											</li>
											<li>
												<div class="form-group">
													<div class="col-md-3 col-md-offset-4">
														<button type="submit" class="btn btn-default">Sing
															in</button>
													</div>
												</div>
											</li>
										</form:form>

									</ul></li>
							</sec:authorize>
							<sec:authorize access="!isAuthenticated()">
								<li><a href="/registration" target="_blank"><img
										src="/images/layouts/register.png">Registration</a></li>
							</sec:authorize>
							<sec:authorize access="isAuthenticated()">
								<li id="logout"><form:form action="/logout" method="POST">
										<img src="/images/layouts/exit.png">

										<button type="submit">Logout</button>
									</form:form></li>
								<sec:authorize access="hasRole('ROLE_ADMIN')">
									<li><a href="/admin"><img
											src="/images/layouts/admin.png"> Moderating</a></li>
								</sec:authorize>

								<li><a href="/basket"><img
										src="/images/layouts/basket.png">Basket</a></li>
							</sec:authorize>

						</ul>
					</div>

				</div>
			</nav>
		</div>
	</div>
</header>
<div class="row">
	<div class="col-md-12">
		<div class="containfer-fluid">
			<div class="row" id="subheader">
				<div class="col-md-4 col-md-offset-1" id="logo">
					<a href="/"><img src="/images/layouts/logo.png">
						<p id="nearlogo">Camping equipment</p></a>
				</div>

				<div class="col-md-3 col-md-offset-1" id="search">
				<form:form class="form-horizontal filter" action="/search"
							method="GET" modelAttribute="filter">
					<div class="form-group">
						<form:input class="form-control" path="nameSearch"
							placeholder="Name" />
						<p>
							<a href="/search">Advanced search</a>
						</p>

					</div>
				</form:form>
				</div>
				<div class="col-md-1" id="searchbutton">
					<button type="submit" class="btn btn-primary">
						<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
					</button>
				</div>
	
				<div class="col-md-2" id="socnetworks">
					<a href="https://www.facebook.com" target="_blank"><img
						src="/images/layouts/facebook.png"></a> <a href="https://vk.com"
						target="_blank"><img src="/images/layouts/vk.png"></a> <a
						href="https://plus.google.com" target="_blank"><img
						src="/images/layouts/google-plus.png"></a>
				</div>
			</div>
		</div>
	</div>
</div>
