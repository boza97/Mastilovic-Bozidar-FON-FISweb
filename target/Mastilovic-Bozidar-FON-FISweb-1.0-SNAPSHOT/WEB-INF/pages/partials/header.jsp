
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="mastilovic.bozidar.fon.fisweb.model.User"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<%
    User user = (User) request.getSession(true).getAttribute("user");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>

        <link rel="stylesheet" href="${root}/assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="${root}/assets/css/style.css" type="text/css">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <a class="navbar-brand" href="${root}/app/home">Homework</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <c:if test="${user != null}">
                <div class="collapse navbar-collapse" id="navbarSupportedContent">

                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Department
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="${root}/app/department/all">All</a>
                                <a class="dropdown-item" href="${root}/app/department/add">New</a>
                            </div>
                        </li>

                        <li class="nav-item pull-right">
                            <a class="nav-link" href="/homework/app/logout">Logout</a>
                        </li>

                    </ul>
                </div>
            </c:if>

        </nav>

        <div class="wraper">