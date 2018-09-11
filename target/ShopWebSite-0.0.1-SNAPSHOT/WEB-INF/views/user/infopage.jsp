<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<link rel="stylesheet" href="/resources/css/selector.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- <link rel="stylesheet" href="/resources/css/index.css"> -->

<div id="main">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2 col-md-offset-1">
				<div class="row">
					<div class="col-md-12" id="leftselector">
						<p id="selections">Categories</p>
						<c:forEach items="${categories}" var="category">
							<p>
								<a href="/category/${category.id}">${category.name}</a>
							</p>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<h3>This is test version of web-shop.</h3>
				<h3>Functions like this doesn't work</h3>
				<h3><a href="/">Back to the main page</a></h3>
			</div>
			<div class="col-md-2 col-md-offset-2" id="rightcol">
				<div class="row">
					<div class="col-md-12">
						<a href=""><img src="/images/layouts/ad.jpg" width="250"
							height="250"></a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>