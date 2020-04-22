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
public class DeleteDepartmentAction extends AbstractAction {

    private DepartmentService departmentService;

    public DeleteDepartmentAction() {
        departmentService = new DepartmentService();
    }

    @Override
    public String execute(HttpServletRequest request) {
        User user = (User) request.getSession(true).getAttribute("user");
        if (user == null) {
            return PageConstants.VIEW_LOGIN;
        }
        Long id = Long.parseLong(request.getParameter("departmentId"));
        List<Department> departments = (List<Department>) request.getServletContext().getAttribute("departments");

        departmentService.delete(id, departments);

        return PageConstants.VIEW_ALL_DEPARTMENTS;
    }
}
