package com.department.controller;

import com.department.model.Department;
import com.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<List<Department>> findAll(){
        return ResponseEntity.ok(departmentService.findAllDepartments());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Department> findById(@PathVariable Long id){
        return ResponseEntity.ok(departmentService.findByIdDepartment(id));
    }

    @PostMapping
    public ResponseEntity<Department> save(@Valid @RequestBody Department department){
        return new ResponseEntity<>(departmentService.saveDepartment(department), HttpStatus.CREATED);
    }
}
