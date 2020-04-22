/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastilovic.bozidar.fon.fisweb.service;

import java.util.List;
import java.util.Objects;
import mastilovic.bozidar.fon.fisweb.model.Department;

/**
 *
 * @author Bozidar
 */
public class DepartmentService {
    
    public Long save(Department department, List<Department> departments){
        Long id = 0l;
        
        for (Department tempDepartment : departments) {
            if(tempDepartment.getId() > id)
                id = tempDepartment.getId();
        }
        
        id++;
        department.setId(id);
        departments.add(department);
        
        return id;
    }
    
    public boolean update(Department department, List<Department> departments){
        for (Department tempDepartment : departments) {
            if(tempDepartment.equals(department)){
                tempDepartment.setName(department.getName());
                tempDepartment.setShortName(department.getShortName());
                return true;
            }               
        }
        return false;
    }
    
    public boolean delete(Long departmentId, List<Department> departments){
        for (int i = 0; i < departments.size(); i++) {
            if(Objects.equals(departments.get(i).getId(), departmentId)){
                departments.remove(i);
                return true;
            }
        }
        return false;
    }
}
