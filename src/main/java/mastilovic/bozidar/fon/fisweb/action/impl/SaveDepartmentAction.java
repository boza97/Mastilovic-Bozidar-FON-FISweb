/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastilovic.bozidar.fon.fisweb.action.impl;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import mastilovic.bozidar.fon.fisweb.action.AbstractAction;
import mastilovic.bozidar.fon.fisweb.constants.PageConstants;
import mastilovic.bozidar.fon.fisweb.model.Department;
import mastilovic.bozidar.fon.fisweb.model.User;
import mastilovic.bozidar.fon.fisweb.service.DepartmentService;

/**
 *
 * @author Bozidar
 */
public class SaveDepartmentAction extends AbstractAction {

    private DepartmentService departmentService;

    public SaveDepartmentAction() {
        departmentService = new DepartmentService();
    }

    @Override
    public String execute(HttpServletRequest request) {

        User user = (User) request.getSession(true).getAttribute("user");

        if (user == null) {
            return PageConstants.VIEW_LOGIN;
        }

        String shortName = request.getParameter("shortName");
        String name = request.getParameter("name");

        String shortNameError = shortName.isEmpty() ? "Field must not be empty" : "";
        String nameError = name.isEmpty() ? "Field must not be empty" : "";

        if (!shortNameError.isEmpty() || !nameError.isEmpty()) {
            request.setAttribute("shortNameError", shortNameError);
            request.setAttribute("nameError", nameError);
        } else {
            List<Department> departments = (List<Department>) request.getServletContext().getAttribute("departments");
            Department department = new Department(-1l, shortName, name);

            departmentService.save(department, departments);
        }

        return PageConstants.VIEW_ADD_DEPARTMENT;
    }

}
