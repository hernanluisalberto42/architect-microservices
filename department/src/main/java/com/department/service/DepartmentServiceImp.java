package com.department.service;

import com.department.config.CustomNotFoundException;
import com.department.model.Department;
import com.department.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DepartmentServiceImp implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;


    @Override
    public List<Department> findAllDepartments() {
        return StreamSupport.stream(
                departmentRepository.findAll()
                        .spliterator(),
                false
         ).collect(Collectors.toList());

    }

    @Override
    public Department findByIdDepartment(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(()->new CustomNotFoundException("Not Found!!"));
    }

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }
}
