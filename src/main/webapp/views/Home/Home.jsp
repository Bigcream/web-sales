<%-- 
    Document   : Home
    Created on : 4 thg 1, 2022, 21:22:06
    Author     : ADMIN
--%>
<%@include file = "/Comons/taglib.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>

        <!-- Content -->
        <div id="content"> 

            <!-- New Arrival -->
            <section class="padding-top-100 padding-bottom-100">
                <div class="container"> 

                    <!-- Main Heading -->
                    <div class="heading text-center">
                        <h4>new arrival</h4>
                        <span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec faucibus maximus vehicula. 
                            Sed feugiat, tellus vel tristique posuere, diam</span> </div>
                </div>

                <!-- New Arrival -->
                <div class="arrival-block"> 
                    <c:forEach var="item" items="${model.listResult}">
                        <div class="item"> 
                            <!-- Images --> 
                            <img class="img-1" src="${item.image_Link}" style="height: 312px;width: 342px" alt=""> <img class="img-2" src="${item.image_Link}" style="height: 312px;width: 342px" alt=""> 
                            <!-- Overlay  -->
                            <div class="overlay"> 
                                <!-- Price --> 
                                <span class="price"><small>$</small>${item.price}</span>
                                <div class="position-center-center"> <a href="<c:url value="/HomeDetail?id=${item.id}"/>" class="icon-magnifier"><i  ></i></a> </div>
                            </div>
                            <!-- Item Name -->
                            <div class="item-name"> <a href="<c:url value="/HomeDetail?id=${item.id}"/>">${item.name}</a>
                                <p>Lorem ipsum dolor sit amet</p>
                            </div>
                        </div>
                    </c:forEach>
                    <!-- Item -->



                </div>
            </section>

            <!-- Popular Products -->
            <section class="padding-top-50 padding-bottom-150">
                <div class="container"> 

                    <!-- Main Heading -->
                    <div class="heading text-center">
                        <h4>popular products</h4>
                        <span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec faucibus maximus vehicula. 
                            Sed feugiat, tellus vel tristique posuere, diam</span> </div>

                    <!-- Popular Item Slide -->
                    <div class="papular-block block-slide"> 
                        <c:forEach var="item" items="${model.listResult}">
                            <!-- Item -->

                            <div class="item"> 

                                <!-- Item img -->
                                <div class="item-img"> <img class="img-1" src="${item.image_Link}" style="height: 170px;width: 242px" alt="" > <img class="img-2" src="${item.image_Link}" style="height: 170px;width: 242px" alt="" > 
                                    <!-- Overlay -->
                                    <form action="<c:url value='/Cart?id=${item.id}'/>"  method="POST">
                                        <div class="overlay">
                                            <div class="position-center-center">
                                                <div class="inn"><a href="<c:url value="/HomeDetail?id=${item.id}"/>" ><i class="icon-magnifier"></i></a> </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <!-- Item Name -->
                                <div class="item-name"> <a href="#.">${item.name}</a>

                                </div>
                                <!-- Price --> 
                                <span class="price"><small>$</small>${item.price}</span> </div>

                        </c:forEach>
                    </div>


                </div>
            </section>

            <!-- Knowledge Share -->
            <section class="light-gray-bg padding-top-150 padding-bottom-150">
                <div class="container"> 

                    <!-- Main Heading -->
                    <div class="heading text-center">
                        <h4>knowledge share</h4>
                        <span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec faucibus maximus vehicula. 
                            Sed feugiat, tellus vel tristique posuere, diam</span> </div>
                    <div class="knowledge-share">
                        <ul class="row">

                            <!-- Post 1 -->
                            <li class="col-md-6">
                                <div class="date"> <span>December</span> <span class="huge">27</span> </div>
                                <a href="#.">Donec commo is vulputate</a>
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec faucibus maximus vehicula. Sed feugiat, tellus vel tristique posuere, diam</p>
                                <span>By <strong>Admin</strong></span> </li>

                            <!-- Post 2 -->
                            <li class="col-md-6">
                                <div class="date"> <span>December</span> <span class="huge">09</span> </div>
                                <a href="#.">Donec commo is vulputate</a>
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec faucibus maximus vehicula. Sed feugiat, tellus vel tristique posuere, diam</p>
                                <span>By <strong>Admin</strong></span> </li>
                        </ul>
                    </div>
                </div>
            </section>

            <!-- Testimonial -->
            <section class="testimonial padding-top-100">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-6"> 

                            <!-- SLide -->
                            <div class="single-slide"> 

                                <!-- Slide -->
                                <div class="testi-in"> <i class="fa fa-quote-left"></i>
                                    <p>Phasellus lacinia fermentum bibendum. Interdum et malesuada fames ac ante ipsum primis in faucibus. Sed ullamcorper sapien lacus, eu posuere odio luctus non. Nulla lacinia, eros vel fermentum consectetur, risus p</p>
                                    <h5>john smith</h5>
                                </div>

                                <!-- Slide -->
                                <div class="testi-in"> <i class="fa fa-quote-left"></i>
                                    <p>Phasellus lacinia fermentum bibendum. Interdum et malesuada fames ac ante ipsum primis in faucibus. Sed ullamcorper sapien lacus, eu posuere odio luctus non. Nulla lacinia, eros vel fermentum consectetur, risus p</p>
                                    <h5>john smith</h5>
                                </div>

                                <!-- Slide -->
                                <div class="testi-in"> <i class="fa fa-quote-left"></i>
                                    <p>Phasellus lacinia fermentum bibendum. Interdum et malesuada fames ac ante ipsum primis in faucibus. Sed ullamcorper sapien lacus, eu posuere odio luctus non. Nulla lacinia, eros vel fermentum consectetur, risus p</p>
                                    <h5>john smith</h5>
                                </div>
                            </div>
                        </div>

                        <!-- Img -->
                        <div class="col-sm-6"> <img class="img-responsive" src="images/testi-avatar.jpg" alt=""> </div>
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
    </body>
</html>
