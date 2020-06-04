<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" />
<c:set var="user" value="${sessionScope.user}" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>

        <link rel='stylesheet' href='${root}/webjars/bootstrap/4.4.1/css/bootstrap.min.css'>        
        <link rel="stylesheet" href="${root}/assets/css/style.css">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <a class="navbar-brand" href="${root}/home">Homework</a>
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
                                <a class="dropdown-item" href="${root}/department/all">All</a>
                                <a class="dropdown-item" href="${root}/department/add">New</a>
                            </div>
                        </li>

                        <li class="nav-item pull-right">
                            <a class="nav-link" href="${root}/logout">Logout</a>
                        </li>
                    </ul>
                </div>
            </c:if>

        </nav>

        <div class="wraper">