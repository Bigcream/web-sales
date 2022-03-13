<%-- 
    Document   : Cart
    Created on : Feb 24, 2022, 12:55:35 AM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file = "/Comons/taglib.jsp" %>
<!DOCTYPE html>
<!-- Content -->
<div id="content"> 
    <!--======= PAGES INNER =========-->
    <section class="padding-top-100 padding-bottom-100 pages-in chart-page">
        <div class="container"> 
            <!-- Payments Steps -->
            <div class="shopping-cart text-center">

                <div class="cart-head">
                    <ul class="row">
                        <!-- PRODUCTS -->
                        <li class="col-sm-2 text-left">
                            <h6>PRODUCTS</h6>
                        </li>
                        <!-- NAME -->
                        <li class="col-sm-4 text-left">
                            <h6>NAME</h6>
                        </li>
                        <!-- PRICE -->
                        <li class="col-sm-2">
                            <h6>PRICE</h6>
                        </li>
                        <!-- QTY -->
                        <li class="col-sm-1">
                            <h6>QTY</h6>
                        </li>

                        <!-- TOTAL PRICE -->
                        <li class="col-sm-2">
                            <h6>TOTAL</h6>
                        </li>
                        <li class="col-sm-1"> </li>
                    </ul>
                </div>
                <c:forEach var="item" items="${cart.items}">
                    <!-- Cart Details -->
                    <ul class="row cart-details">
                        <li class="col-sm-6">
                            <div class="media"> 
                                <!-- Media Image -->
                                <div class="media-left media-middle"> <a href="#." class="item-img"> <img class="media-object" src="${item.productModel.image_Link}" style="height: 170px;width: 170px" alt=""> </a> </div>

                                <!-- Item Name -->
                                <div class="media-body">
                                    <div class="position-center-center">
                                        <h5>${item.productModel.name}</h5>
                                        <p>Lorem ipsum dolor sit amet</p>
                                    </div>
                                </div>
                            </div>
                        </li>

                        <!-- PRICE -->
                        <li class="col-sm-2">
                            <div class="position-center-center"> <span class="price"><small>$</small>${item.productModel.price}</span> </div>
                        </li>

                        <!-- QTY -->
                        <li class="col-sm-1">
                            <div class="position-center-center">
                                <div class="quinty"> 
                                    <!-- QTY -->
                                    <p>${item.quantity}</p>
                                </div>
                            </div>

                        </li>

                        <!-- TOTAL PRICE -->
                        <li class="col-sm-2">
                            <div class="position-center-center"> <span class="price"><small>$</small>${cart.totalMoney}</span> </div>
                        </li>
                        <form action="<c:url value='/RemoveCart?id=${item.productModel.id}'/>"  method="POST">
                            <!-- REMOVE -->
                            <li class="col-sm-1">
                                <div class="position-center-center"> <button type="submit" ><i class="icon-close"></i></button> </div>
                            </li>
                        </form>
                    </ul>
                </c:forEach>

            </div>
        </div>
    </section>

    <!--======= PAGES INNER =========-->
    <section class="padding-top-100 padding-bottom-100 light-gray-bg shopping-cart small-cart">
        <div class="container"> 

            <!-- SHOPPING INFORMATION -->
            <div class="cart-ship-info margin-top-0">
                <div class="row"> 

                    <!-- DISCOUNT CODE -->
                    <div class="col-sm-7">
                        <h6>DISCOUNT CODE</h6>
                        <form>
                            <input type="text" value="" placeholder="ENTER YOUR CODE IF YOU HAVE ONE">
                            <button type="submit" class="btn btn-small btn-dark">APPLY CODE</button>
                        </form>
                        <div class="coupn-btn"> <a href="<c:url value="/HomeWeb"/>" class="btn">Continue shopping</a> <a href="<c:url value='/CheckOut'/>" class="btn">Check out</a> </div>
                    </div>

                    <!-- SUB TOTAL -->
                    <div class="col-sm-5">
                        <h6>grand total</h6>
                        <div class="grand-total">
                            <div class="order-detail">
                                <c:forEach var="item" items="${cart.items}">
                                    <p class="all-total">${item.productModel.name} <span>${item.quantity}</span> </br> <span>$${item.productModel.price*item.quantity}</span> </br></p>
                                </c:forEach>
                                <!-- SUB TOTAL -->
                                <p class="all-total">TOTAL COST <span> $${cart.totalMoney}</span></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- About -->
    <section class="small-about padding-top-150 padding-bottom-150">
        <div class="container"> 

            <!-- Main Heading -->
            <div class="heading text-center">
                <h4>about PAVSHOP</h4>
                <p>Phasellus lacinia fermentum bibendum. Interdum et malesuada fames ac ante ipsumien lacus, eu posuere odio luctus non. Nulla lacinia,
                    eros vel fermentum consectetur, risus purus tempc, et iaculis odio dolor in ex. </p>
            </div>

            <!-- Social Icons -->
            <ul class="social_icons">
                <li><a href="#."><i class="icon-social-facebook"></i></a></li>
                <li><a href="#."><i class="icon-social-twitter"></i></a></li>
                <li><a href="#."><i class="icon-social-tumblr"></i></a></li>
                <li><a href="#."><i class="icon-social-youtube"></i></a></li>
                <li><a href="#."><i class="icon-social-dribbble"></i></a></li>
            </ul>
        </div>
    </section>

    <!-- News Letter -->
    <section class="news-letter padding-top-150 padding-bottom-150">
        <div class="container">
            <div class="heading light-head text-center margin-bottom-30">
                <h4>NEWSLETTER</h4>
                <span>Phasellus lacinia fermentum bibendum. Interdum et malesuada fames ac ante ipsumien lacus, eu posuere odi </span> </div>
            <form>
                <input type="email" placeholder="Enter your email address" required>
                <button type="submit">SEND ME</button>
            </form>
        </div>
    </section>
</div>
