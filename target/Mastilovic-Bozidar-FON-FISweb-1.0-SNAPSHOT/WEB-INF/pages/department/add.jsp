<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" />

<div class="wraper">
    <div class="pt-5 w-50" id="add-department">
        <h2 class="text-center">Create</h2>
        <%@include file="/WEB-INF/pages/partials/messages.jsp" %>

        <form:form action="${root}/department/save" method="POST" modelAttribute="departmentDto">
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

            <button type="submit" class="btn btn-primary">Save</button>
        </form:form>
    </div>
</div>