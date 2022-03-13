<%-- 
    Document   : Login
    Created on : Feb 12, 2022, 4:55:20 PM
    Author     : ASUS
--%>
<%@include file="/Comons/taglib.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body id="LoginForm">
        <div class="container">
            <div class="login-form">
                <c:if test="${not empty messageRegister}">
                    <div class="alert alert-${alertRegister}">
                        ${messageRegister}
                    </div>
                </c:if>
                <div class="main-div">
                    <div class="panel">
                        <h2>Account Login</h2>
                        <p>Please enter your name and password</p>
                    </div>
                    <form action="<c:url value='/Login'/>" id="formLogin" method="POST">
                        <div class="form-group">
                            <input type="userName" class="form-control" id="userName" placeholder="UserName" name="userName">
                        </div>

                        <div class="form-group">
                            <input type="password" class="form-control" id="passWord" placeholder="Password" name="passWord">
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" id="Repeatpassword" placeholder="RepeatPassword" name="repeatPassWord">
                        </div>
                        <div class="form-group">
                            <input type="fullName" class="form-control" id="Repeatpassword" placeholder="fullName" name="fullName">
                        </div>
                        <div class="form-group">
                            <input type="email" class="form-control" id="email" placeholder="Email" name="email">
                        </div>
                        <input type="hidden" value="register" name="action"/>
                        <button type="submit" class="btn btn-primary">Register</button>
                        </br>
                        </br>
                        <div class="forgot">
                            <a style="float: right" href='<c:url value="/Login?action=login"/>'>Login here</a>
                        </div>
                    </form>
                </div>
                <p class="botto-text"> Designed by Sunil Rajput</p>
            </div>
        </div>
    </body>
</html>
