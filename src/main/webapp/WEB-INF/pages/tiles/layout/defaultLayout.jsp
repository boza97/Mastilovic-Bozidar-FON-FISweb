<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><tiles:getAsString name="title"></tiles:getAsString></title>

        <link rel='stylesheet' href='${root}/webjars/bootstrap/4.4.1/css/bootstrap.min.css'>        
        <link rel="stylesheet" href="${root}/assets/css/style.css">
    </head>
    <body>
        <header>
            <tiles:insertAttribute name="header"/>
        </header>

        <section id="content">
            <tiles:insertAttribute name="body"/>
        </section>

        <footer>
            <tiles:insertAttribute name="footer"/>
        </footer>

        <script type="text/javascript" src="${root}/webjars/jquery/3.1.1/jquery.min.js"></script>            
        <script type="text/javascript" src="${root}/webjars/bootstrap/4.4.1/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="${root}/webjars/popper.js/1.16.0/umd/popper.min.js"></script>
    </body>
</html>
