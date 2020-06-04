<%@include file="/WEB-INF/pages/partials/directives.jsp"%>
<%@include file="/WEB-INF/pages/partials/header.jsp" %>

<div class="pt-5" id="table-departments">
    <table class="table" id="table-departments">
        <thead class="thead-dark">
            <tr>
                <th class="text-center" scope="col">ID</th>
                <th class="text-center" scope="col">Short name</th>
                <th class="text-center" scope="col">Name</th>
                <th class="text-center" scope="col">Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${departments}" var="department">
                <tr id="department${department.id}">
                    <td class="text-center">${department.id}</td>
                    <td class="text-center">${department.shortName}</td>
                    <td class="text-center">${department.name}</td>
                    <td class="text-center">
                        <a class="btn btn-primary" href="${root}/department/${department.id}/edit">Edit</a>
                        <a class="btn btn-danger" href="${root}/department/${department.id}/delete">X</a>
                    </td>
                </tr>
            </c:forEach>

            <c:if test="${departments.isEmpty()}">
                <tr>
                    <td class="text-center" colspan="5">${emptyTable}</td>
                </tr>
            </c:if>

        </tbody>
    </table>
</div>

<%@include file="/WEB-INF/pages/partials/scripts.jsp"%>
<%@include file="/WEB-INF/pages/partials/footer.jsp"%>