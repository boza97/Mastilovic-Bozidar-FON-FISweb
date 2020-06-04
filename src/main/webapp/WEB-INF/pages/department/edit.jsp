<%@include  file="/WEB-INF/pages/partials/directives.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include  file="/WEB-INF/pages/partials/header.jsp"%>

<div class="pt-5 w-50" id="add-department">
    <h2 class="text-center">Edit</h2>

    <%@include file="/WEB-INF/pages/partials/messages.jsp" %>

    <form:form action="${root}/department/update" modelAttribute="departmentDto">
        <input type="hidden" name="_method" value="PATCH">
        <form:hidden path="id"/>        
        
        <div class="form-group">
            <label for="shortName" class="col-form-label">Short name:</label>
            <form:input type="text" class="form-control" id="shortName" path="shortName"/>
            <p style="color: red;"><form:errors path="shortName"/></p>
        </div>

        <div class="form-group">
            <label for="departmentName" class="col-form-label">Name:</label>
            <form:input type="text" class="form-control" id="departmentName" path="name"/>
            <p style="color: red;"><form:errors path="name"/></p>
        </div>    

        <button type="submit" class="btn btn-primary">Save Changes</button>
    </form:form>
</div>

<%@include file="/WEB-INF/pages/partials/scripts.jsp"%>
<%@include file="/WEB-INF/pages/partials/footer.jsp"%>
