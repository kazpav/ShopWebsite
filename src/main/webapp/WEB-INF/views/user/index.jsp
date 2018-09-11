<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec"
           uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<link rel="stylesheet" href="/resources/css/selector.css">
<link rel="stylesheet" href="/resources/css/slider.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="/resources/js/slider.js"></script>

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
                <div class="row">
                    <div class="col-md-12">
                        <p>Our shop on the map</p>
                        <iframe
                                src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2572.878846840802!2d24.026820264422387!3d49.84473391789522!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0xf9783fecb4fecf1f!2z0JvRjNCy0ZbQstGB0YzQutC40Lkg0J3QsNGG0ZbQvtC90LDQu9GM0L3QuNC5INCQ0LrQsNC00LXQvNGW0YfQvdC40Lkg0YLQtdCw0YLRgCDQvtC_0LXRgNC4INGC0LAg0LHQsNC70LXRgtGDINGW0LwuINCh0L7Qu9C-0LzRltGXINCa0YDRg9GI0LXQu9GM0L3QuNGG0YzQutC-0Zc!5e0!3m2!1suk!2sua!4v1478396662149"
                                width="600" height="450" frameborder="0" style="border: 0"
                                allowfullscreen></iframe>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="slider">
                            <ul>
                                <c:forEach items="${randomCommodities}" var="commodity">
                                    <li><img src="/images/commodity/${commodity.id}.jpg?version=${commodity.version}" height="300" width="300"></li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>
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
<!--
<div id="main" class="row">
<div class="container-fluid">
<div class="row">
<div class="col-md-2 col-md-offset-1">
<div class="row">
<div class="col-md-12" id="leftselector">
<p id="selections">Розділи</p>
<c:forEach items="${categories}" var="category">
    <p>
    <a href="/category/${category.id}">${category.name}</a>
    </p>
</c:forEach>
<p>
<a href="">Палатки</a>
</p>
</div>
</div>
</div>
<div class="col-md-4 ">
<div class="row">
<div class="col-md-4">
<sec:authorize access="isAuthenticated()">
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <a href="/admin">admin</a>
    </sec:authorize>
    <form:form action="/logout" method="POST">
        <button type="submit" class="btn btn-danger">Logout</button>
    </form:form>
</sec:authorize>

<sec:authorize access="!isAuthenticated()">
    <a href="/login">Login</a>
    <a href="/registration">Registration</a>
</sec:authorize>
</div>
</div>
<div class="row">
<div class="col-md-9 col-md-offset-3">
<div class='sliderA'>
<input type="radio" name="slider1" id="slider1_1"
checked="checked"> <label for="slider1_1"></label>
<div>
<p>
Акція! Рюкзак <br>Osprey Aether 60.<br> <font
color="green">5 100 грн</font>.<br> <s><font
color="red">6 263 грн</font></s>
</p>
<img src='images/OspreyBackpack.jpg' alt=''>
</div>

<input type="radio" name="slider1" id="slider1_2"> <label
for="slider1_2"></label>
<div>
<p>Топ продажу! Палатка Turbat Runa 2. 2 499 грн</p>
<img src='images/TurbatRunaTent.jpg' alt=''>
</div>

<input type="radio" name="slider1" id="slider1_3"> <label
for="slider1_3"></label>
<div>
<p>Акція! Каремат Горгани 12 мм. 159 грн</p>
<img src='images/caremat.jpg' alt=''>
</div>

<input type="radio" name="slider1" id="slider1_4"> <label
for="slider1_4"></label>
<div>
<p>Топ продажу! Газова горілка Fire Maple 105. 750 грн</p>
<img src='images/gorilka.jpg' alt=''>
</div>
</div>
</div>
<div class="col-md-11 col-md-offset-1" id="map">
Ми на карті <br>
<iframe
src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2572.878846840802!2d24.026820264422387!3d49.84473391789522!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0xf9783fecb4fecf1f!2z0JvRjNCy0ZbQstGB0YzQutC40Lkg0J3QsNGG0ZbQvtC90LDQu9GM0L3QuNC5INCQ0LrQsNC00LXQvNGW0YfQvdC40Lkg0YLQtdCw0YLRgCDQvtC_0LXRgNC4INGC0LAg0LHQsNC70LXRgtGDINGW0LwuINCh0L7Qu9C-0LzRltGXINCa0YDRg9GI0LXQu9GM0L3QuNGG0YzQutC-0Zc!5e0!3m2!1suk!2sua!4v1478396662149"
width="600" height="450" frameborder="0" style="border: 0"
allowfullscreen></iframe>
</div>
</div>
</div>
<div class="col-md-2 col-md-offset-3" id="rightcol">
<div class="row">
<div class="col-md-12">
<a href=""><img src="/images/layouts/ad.jpg" width="200"
height="auto"></a>
</div>
</div>
</div>
</div>
<div class="row">
<div class="col-md-10 col-md-offset-1" id="topsalemark">Топ
продажу</div>
</div>
<div class="row" id="topsales">
<div class="col-md-2 col-md-offset-1">
<img src="images/item1.jpg" width="200" height="200"> Спальник
Deuter 49288 Dream lite 250 2320, R
</div>
<div class="col-md-2 col-md-offset-1">
<img src="images/item2.jpg" width="200" height="200"> Палатка
Trimm Comet 2 yellow
</div>
<div class="col-md-2 col-md-offset-1">
<img src="images/item3.jpg" width="200" height="200"> Рюкзак
Deuter 33432 Aircontact 50+10 SL 2404
</div>
</div>
<div class="row">
<div class="col-md-10 col-md-offset-1" id="topsalemark">Акції</div>
</div>
<div class="row" id="topsales">
<div class="col-md-2 col-md-offset-1">
<img src="images/item4.jpg" width="200" height="200"> Рюкзак
Deuter 35129 Traveller 55+10 SL 4110
</div>
<div class="col-md-2 col-md-offset-1">
<img src="images/item5.jpeg" width="200" height="200"> Палатка
Tramp Nishe 3
</div>
<div class="col-md-2 col-md-offset-1">
<img src="images/item6.jpg" width="200" height="200"> Ботинки
Campus Cesen II Lady
</div>
</div>
</div>
</div>


////////////////////////////////////////////////////////////
<ul>
<c:forEach items="${categories}" var="category">
    <li><a href="/category/${category.id}">${category.name}</a></li>
</c:forEach>
</ul>
-->
