<%@page import="mastilovic.bozidar.fon.fisweb.model.Department"%>
<%@page import="java.util.List"%>

<%@include file="/WEB-INF/pages/partials/directives.jsp"%>

<c:set var="departments" value="${applicationScope.departments}" />
<%@include file="/WEB-INF/pages/partials/header.jsp" %>

<div class="pt-5" id="table-departments">
    <table class="table" id="table-departments">
        <thead class="thead-dark">
            <tr>
                <th class="text-center" scope="col">Short name</th>
                <th class="text-center" scope="col">Name</th>
                <th class="text-center" scope="col">Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${departments}" var="department">
                <tr id="department${department.id}">
                    <td class="text-center">${department.shortName}</td>
                    <td class="text-center">${department.name}</td>
                    <td class="text-center">
                        <button type="button" class="btn btn-primary" onclick="onEditDepartment(${department.id}, '${department.shortName}', '${department.name}')">Edit</button>
                        <a class="btn btn-danger" href="${root}/app/department/delete?departmentId=${department.id}">X</a>
                    </td>
                </tr>
            </c:forEach>

            <c:if test="${departments.size() == 0}">
                <tr>
                    <td class="text-center" colspan="5">There is no departments!</td>
                </tr>
            </c:if>

        </tbody>
    </table>
</div>

<div class="modal fade" id="editDepartmentModal" tabindex="-1" role="dialog" aria-labelledby="editDepartmentModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="editDepartmentModalLabel">Edit</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form action="${root}/app/department/update" method="POST">
                <div class="modal-body">

                    <input id="departmentId" name="departmentId" hidden></input>
                    <div class="form-group">
                        <label for="shortName" class="col-form-label">Short name:</label>
                        <input type="text" class="form-control" id="shortName" required="required" name="shortName">
                    </div>
                    <div class="form-group">
                        <label for="departmentName" class="col-form-label">Name:</label>
                        <input class="form-control" id="departmentName" required="required" name="name"></input>
                    </div>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Update</button>
                </div>
            </form>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/pages/partials/scripts.jsp"%>

<script>
    function onEditDepartment(id, shortName, name) {
        $('#departmentId').val(id);
        $('#shortName').val(shortName);
        $('#departmentName').val(name);

        $('#editDepartmentModal').modal('toggle');
    }
</script>
<%@include file="/WEB-INF/pages/partials/footer.jsp"%>
