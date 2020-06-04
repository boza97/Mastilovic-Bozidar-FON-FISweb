/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastilovic.bozidar.fon.fisweb.service.impl;

import java.util.List;
import mastilovic.bozidar.fon.fisweb.dto.DepartmentDto;
import mastilovic.bozidar.fon.fisweb.repository.DepartmentRepository;
import mastilovic.bozidar.fon.fisweb.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Bozidar
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public void save(DepartmentDto department) {
        departmentRepository.save(department);
    }

    @Override
    public void delete(Long id) {
        departmentRepository.delete(id);
    }

    @Override
    public void update(DepartmentDto department) {
        departmentRepository.update(department);
    }

    @Override
    public List<DepartmentDto> getAll() {
        return departmentRepository.getAll();
    }

    @Override
    public DepartmentDto findById(Long departmentId) {
        return departmentRepository.findById(departmentId);
    }
}
