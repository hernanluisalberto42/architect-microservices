package com.department.service;

import com.department.model.Department;

import java.util.List;

public interface DepartmentService {

    public List<Department> findAllDepartments();

    public Department findByIdDepartment(Long id);

    public Department saveDepartment(Department department);
}
