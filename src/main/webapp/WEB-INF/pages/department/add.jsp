<%@include  file="/WEB-INF/pages/partials/directives.jsp"%>
<%@include  file="/WEB-INF/pages/partials/header.jsp"%>

<div class="pt-5 w-50" id="add-department">
    <h2 class="text-center">Create</h2>

    <form action="${root}/app/department/save" method="POST">
        <div class="form-group">
            <label for="shortName" class="col-form-label">Short name:</label>
            <input type="text" class="form-control" id="shortName" name="shortName">
            <p style="color: red;">${shortNameError}</p>
        </div>

        <div class="form-group">
            <label for="departmentName" class="col-form-label">Name:</label>
            <input type="text" class="form-control" id="departmentName" name="name"></input>
            <p style="color: red;">${nameError}</p>
        </div>

        <button type="submit" class="btn btn-primary">Save</button>
    </form>
</div>


<%@include file="/WEB-INF/pages/partials/scripts.jsp"%>
<%@include file="/WEB-INF/pages/partials/footer.jsp"%>
