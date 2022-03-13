
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/Comons/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title><dec:title default="Home" /></title>
        <meta charset="utf-8">
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <!-- SLIDER REVOLUTION 4.x CSS SETTINGS -->

        <link rel="stylesheet" type="text/css" href="<c:url value='/Template/Paging/rs-plugin/css/settings.css' />" media="screen" />

        <!-- Bootstrap Core CSS -->

        <link href="<c:url value='/Template/Paging/css/bootstrap.min.css' />" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="<c:url value='/Template/Paging/css/font-awesome.min.css' />" rel="stylesheet" type="text/css">
        <link href="<c:url value='/Template/Paging/css/ionicons.min.css' />" rel="stylesheet">
        <link href="<c:url value='/Template/Paging/css/main.css' />" rel="stylesheet">
        <link href="<c:url value='/Template/Paging/css/style.css' />" rel="stylesheet">
        <link href="<c:url value='/Template/Paging/css/responsive.css' />" rel="stylesheet">

        <!-- JavaScripts -->

        <script src="<c:url value='/Template/Paging/js/modernizr.js' />"></script>

        <!-- Online Fonts -->


        <link href="<c:url value='https://fonts.googleapis.com/css?family=Montserrat:400,700' />" rel='stylesheet' type='text/css'>
        <link href="<c:url value='https://fonts.googleapis.com/css?family=Playfair+Display:400,700,900' />" rel='stylesheet' type='text/css'>

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <div id="wrap" >
            <!-- header -->
            <%@ include file="/Comons/Home/Header.jsp" %>
            <!-- header -->
            <dec:body/>
        </div>
        <!-- footer -->
        <%@ include file="/Comons/Home/Footer.jsp" %>
        <!-- footer -->
        <script src="<c:url value='/Template/Paging/js/jquery-1.11.3.min.js' />"></script> 
        <script src="<c:url value='/Template/Paging/js/bootstrap.min.js' />"></script> 
        <script src="<c:url value='/Template/Paging/js/own-menu.js' />"></script> 
        <script src="<c:url value='/Template/Paging/js/jquery.lighter.js' />"></script> 
        <script src="<c:url value='/Template/Paging/js/owl.carousel.min.js' />"></script> 

        <!-- SLIDER REVOLUTION 4.x SCRIPTS  --> 




        <script type="text/javascript" src="<c:url value='/Template/Paging/rs-plugin/js/jquery.tp.t.min.js' />"></script> 
        <script type="text/javascript" src="<c:url value='/Template/Paging/rs-plugin/js/jquery.tp.min.js' />"></script> 
        <script src="<c:url value='/Template/Paging/js/main.js' />"></script> 
    </body>
</html>
