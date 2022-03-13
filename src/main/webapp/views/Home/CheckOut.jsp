<%-- 
    Document   : CheckOut
    Created on : Feb 23, 2022, 7:40:12 PM
    Author     : ASUS
--%>
<%@include file="/Comons/taglib.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<!-- Content -->
<div id="content"> 

    <!--======= PAGES INNER =========-->
    <section class="chart-page padding-top-100 padding-bottom-100">
        <div class="container"> 
            <c:if test="${not empty messageOrder}">
                <div class="alert alert-${alertOrder}">
                    ${messageOrder}
                </div>
            </c:if>
            <!-- Payments Steps -->
            <div class="shopping-cart"> 

                <!-- SHOPPING INFORMATION -->
                <div class="cart-ship-info">
                    <div class="row"> 

                        <!-- ESTIMATE SHIPPING & TAX -->
                        <div class="col-sm-7">
                            <h6>BILLING DETAILS</h6>
                            <form action="<c:url value='/CheckOut'/>" method="POST">
                                <c:if test="${not empty address}">
                                    <ul class="row">

                                        <!-- Name -->
                                        <li class="col-md-6">
                                            <label> *NAME
                                                <input type="text" name="name" value="${address.name}" placeholder="">
                                            </label>
                                        </li>

                                        <li class="col-md-6"> 
                                            <!-- ADDRESS -->
                                            <label>*ADDRESS
                                                <input type="text" name="address" value="${address.address}" placeholder="">
                                            </label>
                                        </li>
                                        <!-- TOWN/CITY -->
                                        <li class="col-md-6">
                                            <label>*TOWN/CITY
                                                <input type="text" name="city" value="${address.city}" placeholder="">
                                            </label>
                                        </li>

                                        <!-- COUNTRY -->
                                        <li class="col-md-6">
                                            <label> COUNTRY
                                                <input type="text" name="country" value="${address.country}" placeholder="">
                                            </label>
                                        </li>

                                        <!-- EMAIL ADDRESS -->
                                        <li class="col-md-6">
                                            <label> *EMAIL ADDRESS
                                                <input type="text" name="email" value="${address.email}" placeholder="">
                                            </label>
                                        </li>
                                        <!-- PHONE -->
                                        <li class="col-md-6">
                                            <label> *PHONE
                                                <input type="text" name="phoneNumber" value="${address.phoneNumber}" placeholder="">
                                            </label>
                                        </li>
                                    </ul>

                                </c:if>
                                <c:if test="${empty address}">
                                    <ul class="row">

                                        <!-- Name -->
                                        <li class="col-md-6">
                                            <label> *NAME
                                                <input type="text" name="name" value="" placeholder="">
                                            </label>
                                        </li>

                                        <li class="col-md-6"> 
                                            <!-- ADDRESS -->
                                            <label>*ADDRESS
                                                <input type="text" name="address" value="" placeholder="">
                                            </label>
                                        </li>
                                        <!-- TOWN/CITY -->
                                        <li class="col-md-6">
                                            <label>*TOWN/CITY
                                                <input type="text" name="city" value="" placeholder="">
                                            </label>
                                        </li>

                                        <!-- COUNTRY -->
                                        <li class="col-md-6">
                                            <label> COUNTRY
                                                <input type="text" name="country" value="" placeholder="">
                                            </label>
                                        </li>

                                        <!-- EMAIL ADDRESS -->
                                        <li class="col-md-6">
                                            <label> *EMAIL ADDRESS
                                                <input type="text" name="email" value="" placeholder="">
                                            </label>
                                        </li>
                                        <!-- PHONE -->
                                        <li class="col-md-6">
                                            <label> *PHONE
                                                <input type="text" name="phoneNumber" value="" placeholder="">
                                            </label>
                                        </li>

                                        <!-- PHONE -->
                                        <li class="col-md-6">
                                            <input type="hidden" value="newAddress" name="action"/>
                                            <button type="submit" class="btn">Submit Address</button>
                                        </li>

                                        <!-- CREATE AN ACCOUNT -->
                                        <li class="col-md-6">
                                            <div class="checkbox margin-0 margin-top-20">
                                                <input id="checkbox1" class="styled" type="checkbox">
                                                <label for="checkbox1"> Ship to a different address </label>
                                            </div>
                                        </li>
                                    </ul>
                                </c:if>
                            </form>

                            <!-- SHIPPING info -->
                            <h6 class="margin-top-50">SHIPPING info</h6>
                            <form action="<c:url value='/CheckOut?address=newAddress'/>" method="POST">
                                <ul class="row">

                                    <!-- Name -->
                                    <li class="col-md-6">
                                        <label> *NAME
                                            <input type="text" name="first-name" value="" placeholder="">
                                        </label>
                                    </li>
                                    <!-- LAST NAME -->
                                    <li class="col-md-6"> 
                                        <!-- ADDRESS -->
                                        <label>*ADDRESS
                                            <input type="text" name="address" value="" placeholder="">
                                        </label>
                                    </li>
                                    <!-- TOWN/CITY -->
                                    <li class="col-md-6">
                                        <label>*TOWN/CITY
                                            <input type="text" name="town" value="" placeholder="">
                                        </label>
                                    </li>

                                    <!-- COUNTRY -->
                                    <li class="col-md-6">
                                        <label> COUNTRY
                                            <input type="text" name="contry-state" value="" placeholder="">
                                        </label>
                                    </li>

                                    <!-- EMAIL ADDRESS -->
                                    <li class="col-md-6">
                                        <label> *EMAIL ADDRESS
                                            <input type="text" name="contry-state" value="" placeholder="">
                                        </label>
                                    </li>
                                    <!-- PHONE -->
                                    <li class="col-md-6">
                                        <label> *PHONE
                                            <input type="text" name="postal-code" value="" placeholder="">
                                        </label>
                                    </li>

                                    <!-- PHONE -->
                                    <li class="col-md-6">
                                        <button type="submit" class="btn">SUBMIT</button>
                                    </li>
                                </ul>
                            </form>
                        </div>

                        <!-- SUB TOTAL -->
                        <div class="col-sm-5">
                            <h6>YOUR ORDER</h6>
                            <form action="<c:url value='/PlaceOrder'/>" id="formSubmit" method="POST">
                                <div class="order-place">
                                    <c:forEach var="item" items="${cart.items}">
                                        <div class="order-detail">
                                            <p class="all-total">${item.productModel.name} <span>${item.quantity}</span> </br> <span>$${item.productModel.price*item.quantity}</span> </br></p>

                                            <!-- SUB TOTAL -->

                                        </div>
                                    </c:forEach>
                                    <p class="all-total">TOTAL COST <span> $${cart.totalMoney}</span></p>
                                    <div class="pay-meth">
                                        <ul>
                                            <li>
                                                <div class="radio">
                                                    <input type="radio" name="radio1" id="radio1" value="option1" checked>
                                                    <label for="radio1"> DIRECT BANK TRANSFER </label>
                                                </div>

                                            </li>
                                            <li>
                                                <div class="radio">
                                                    <input type="radio" name="radio1" id="radio2" value="option2">
                                                    <label for="radio2"> CASH ON DELIVERY</label>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="radio">
                                                    <input type="radio" name="radio1" id="radio3" value="option3">
                                                    <label for="radio3"> CHEQUE PAYMENT </label>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="radio">
                                                    <input type="radio" name="radio1" id="radio4" value="option4">
                                                    <label for="radio4"> PAYPAL </label>
                                                </div>
                                            </li>
                                        </ul>
                                        <button type="submit" class="btn  btn-dark pull-right margin-top-30">PLACE ORDER</button> </div>
                                </div>
                            </form>

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