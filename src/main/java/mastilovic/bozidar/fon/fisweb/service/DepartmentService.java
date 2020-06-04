/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastilovic.bozidar.fon.fisweb.service;

import java.util.List;
import mastilovic.bozidar.fon.fisweb.dto.DepartmentDto;

/**
 *
 * @author Bozidar
 */
public interface DepartmentService {
    void save(DepartmentDto department);
    void delete(Long id);
    void update(DepartmentDto department);
    DepartmentDto findById(Long departmentId);
    List<DepartmentDto> getAll();
}
