<%-- 
    Document   : Info
    Created on : Feb 25, 2022, 5:29:25 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file = "/Comons/taglib.jsp" %>
<!DOCTYPE html>
<section class="padding-top-100 padding-bottom-100 pages-in chart-page">
    <div class="heading text-center"><b style="font-size: 32px">Orders are being delivered</b></div>
    <div class="container"> 

        <!-- Payments Steps -->
        <div class="shopping-cart text-center">
            <div class="cart-head">
                <ul class="row">
                    <li class="col-sm-2 text-left">
                    </li>
                    <!-- PRODUCTS -->
                    <!-- NAME -->
                    <li class="col-sm-2 text-left">
                        <b>NAME</b>
                    </li>
                    <!-- QTY -->
                    <li class="col-sm-1">
                        <b>QTY</b>
                    </li>

                    <!-- TOTAL PRICE -->
                    <li class="col-sm-2">
                        <b>TOTAL</b>
                    </li>
                    <!-- PRICE -->
                    <li class="col-sm-2">
                        <b>STATUS</b>
                    </li>
                    <li class="col-sm-2">
                        <b>EDIT</b>
                    </li>
                </ul>
            </div>
            <c:forEach var="listOrder" items="${listOrder}">
                <!-- Cart Details -->
                <ul class="row cart-details">
                    <li class="col-sm-4" style="text-align: center">
                        <!-- Media Image -->
                        <!-- Item Name -->
                        <div class="position-center-center">
                            <h1 style="font-size: medium; left: 15px" >${listOrder.detailModel.product_Name}</h1>
                        </div>
                    </li>

                    <!-- QTY -->
                    <li class="col-sm-1">
                        <div class="position-center-center">
                            <div class="quinty"> 
                                <!-- QTY -->
                                <span class="price">${listOrder.detailModel.product_Quantity}</span>
                            </div>
                        </div>
                    </li>

                    <!-- TOTAL PRICE -->
                    <li class="col-sm-2">
                        <div class="position-center-center"> <span class="price"><small>$</small>${listOrder.detailModel.product_Quantity*listOrder.detailModel.product_Price}</span> </div>
                    </li>

                    <li class="col-sm-2">
                        <div class="position-center-center"><button type="submit" class="btn-app">${listOrder.statusModel.status}</button> </div>
                    </li>

                    <!-- REMOVE -->
                    <li class="col-sm-2">
                        <div class="position-center-center"> <a href="<c:url value='/Info?id=${listOrder.detailModel.id}'/>"><i class="icon-close"></i></a> </div>
                    </li>

                </ul>
            </c:forEach>
        </div>
    </div>
</section>

<section class="padding-top-100 padding-bottom-100 pages-in chart-page">
    <div class="heading text-center"><b style="font-size: 32px">Order has been canceled</b></div>
    <div class="container"> 
        <!-- Payments Steps -->
        <div class="shopping-cart text-center">
            <div class="cart-head">
                <ul class="row">
                    <!-- PRODUCTS -->
                    <li class="col-sm-2 text-left">
                        <b>PRODUCTS<b>
                                </li>
                                <!-- NAME -->
                                <li class="col-sm-4 text-left">
                                    <b>NAME<b>
                                            </li>
                                            <!-- PRICE -->
                                            <li class="col-sm-2">
                                                <b>QTY</b>
                                            </li>
                                            <!-- QTY -->
                                            <li class="col-sm-1">
                                                <b>TOTAL</b>
                                            </li>

                                            <!-- TOTAL PRICE -->
                                            <li class="col-sm-2">
                                                <b>STATUS</b>
                                            </li>
                                            <li class="col-sm-1"> </li>
                                            </ul>
                                            </div>

                                            <!-- Cart Details -->
                                            <ul class="row cart-details">
                                                <li class="col-sm-6">
                                                    <div class="media"> 
                                                        <!-- Media Image -->
                                                        <div class="media-left media-middle"> <a href="#." class="item-img"> <img class="media-object" src="images/cart-img-1.jpg" alt=""> </a> </div>

                                                        <!-- Item Name -->
                                                        <div class="media-body">
                                                            <div class="position-center-center">
                                                                <h5>wood chair</h5>
                                                                <p>Lorem ipsum dolor sit amet</p>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </li>


                                                <!-- QTY -->
                                                <li class="col-sm-2">
                                                    <div class="position-center-center">
                                                        <div class="quinty"> 
                                                            <!-- QTY -->
                                                            <span class="price">299</span>
                                                        </div>
                                                    </div>
                                                </li>

                                                <!-- TOTAL PRICE -->
                                                <li class="col-sm-1">
                                                    <div class="position-center-center"> <span class="price"><small>$</small>299</span> </div>
                                                </li>

                                                <!-- REMOVE -->
                                                <li class="col-sm-2">
                                                    <div class="position-center-center"> <span class="price" style="color: red">Cancelled</span></i></a> </div>
                                                </li>
                                            </ul>


                                            </div>
                                            </div>
                                            </section>

