<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ul>
	<c:forEach items="${categories}" var="category">
		<li><a href="/category/${category.id}">${category.name}</a></li>
	</c:forEach>
</ul>

<h3><a href="/registration">Registration page</a></h3>
<br>
<a href="/page1">Page 1 link</a>
<br>
<a href="/page2">Page 2 link</a>
<br>
<a href="/page3">Page 3 link</a>
<br>
<a href="/page4">Page 4 link</a>
<br>
<a href="/page5">Page 5 link</a>