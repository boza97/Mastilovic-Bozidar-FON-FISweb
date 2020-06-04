/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastilovic.bozidar.fon.fisweb.repository.impl;

import java.util.ArrayList;
import java.util.List;
import mastilovic.bozidar.fon.fisweb.dto.DepartmentDto;
import mastilovic.bozidar.fon.fisweb.repository.DepartmentRepository;
import org.springframework.stereotype.Component;

/**
 *
 * @author Bozidar
 */
@Component
public class DepartmentRepositoryImpl implements DepartmentRepository {
    private List<DepartmentDto> departments;

    public DepartmentRepositoryImpl() {
        departments = new ArrayList<>();
    }

    @Override
    public void save(DepartmentDto department) {
        Long id = 1L;
        if (departments.isEmpty()) {
            department.setId(id);
            departments.add(department);
        } else {
            for (DepartmentDto tempDepartment : departments) {
                if (tempDepartment.getId() > id) {
                    id = tempDepartment.getId();
                }
            }
            department.setId(++id);
            departments.add(department);
        }
    }

    @Override
    public void delete(Long id) {
        for (DepartmentDto tempDepartment : departments) {
            if (tempDepartment.getId().equals(id)) {
                departments.remove(tempDepartment);
                break;
            }
        }
    }

    @Override
    public void update(DepartmentDto department) {
        for (DepartmentDto tempDepartment : departments) {
            if (tempDepartment.equals(department)) {
                tempDepartment.setName(department.getName());
                tempDepartment.setShortName(department.getShortName());
            }
        }
    }

    @Override
    public List<DepartmentDto> getAll() {
        return departments;
    }

    @Override
    public DepartmentDto findById(Long departmentId) {
        return departments.stream().filter(department -> department.getId().equals(departmentId)).findAny().orElse(null);
    }
}
