<%@include file="/WEB-INF/pages/partials/directives.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="/WEB-INF/pages/partials/header.jsp"%>

<div class="w-50 mx-auto pt-5">            
    <h2 class="text-center mb-3">Login</h2>

    <form:form action="${root}/login" method="POST" modelAttribute="userDto">
        <div class="form-group">
            <label for="email">Email address:</label>
            <form:input type="email" class="form-control" id="email" path="email"/>
            <p style="color: red;"><form:errors path="email" /></p>
        </div>

        <div class="form-group">
            <label for="password">Password:</label>
            <form:input type="password" class="form-control" id="password" path="password"/>
            <p style="color: red;"><form:errors path="password" /></p>
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
    </form:form>
</div>    

<%@include file="/WEB-INF/pages/partials/scripts.jsp"%>    
<%@include file="/WEB-INF/pages/partials/footer.jsp"%>    

