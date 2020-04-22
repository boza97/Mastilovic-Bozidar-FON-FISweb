<%@include  file="/WEB-INF/pages/partials/directives.jsp"%>
<%@include  file="/WEB-INF/pages/partials/header.jsp"%>

<div class="w-50 mx-auto pt-5">            
    <h2 class="text-center mb-3">Login</h2>

    <form action="/homework/app/login" method="POST">
        <div class="form-group">
            <label for="inputEmail">Email address:</label>
            <input type="email" class="form-control" id="inputEmail" name="email">
            <p style="color: red;">${emailError}</p>
        </div>

        <div class="form-group">
            <label for="inputPassword">Password:</label>
            <input type="password" class="form-control" id="inputPassword" name="password">
            <p style="color: red;">${pwError}</p>
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>    
            
<%@include file="/WEB-INF/pages/partials/scripts.jsp"%>    
<%@include file="/WEB-INF/pages/partials/footer.jsp"%>    

