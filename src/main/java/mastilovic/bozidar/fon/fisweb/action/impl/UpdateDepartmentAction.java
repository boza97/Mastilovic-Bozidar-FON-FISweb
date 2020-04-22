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
import mastilovic.bozidar.fon.fisweb.service.DepartmentService;

/**
 *
 * @author Bozidar
 */
public class UpdateDepartmentAction extends AbstractAction{
    private DepartmentService departmentService;

    public UpdateDepartmentAction() {
        departmentService = new DepartmentService();
    }

    @Override
    public String execute(HttpServletRequest request) {
        
        Long id = Long.parseLong(request.getParameter("departmentId"));
        String shortName = request.getParameter("shortName");
        String name = request.getParameter("name");
        
        Department department = new Department(id, shortName, name);
        List<Department> departments = (List<Department>) request.getServletContext().getAttribute("departments");
        
        departmentService.update(department, departments);
        
        return PageConstants.VIEW_ALL_DEPARTMENTS;
    }
    
}
