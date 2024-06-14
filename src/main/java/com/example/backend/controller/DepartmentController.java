package com.example.backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.model.Department;
import com.example.backend.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public List<Department> getDepartments() {
        return departmentService.getDepartments();
    }

    @GetMapping("/{departmentName}")
    public Department getDepartment(@PathVariable String departmentName) {
        return departmentService.getDepartment(departmentName);
    }

    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.createDepartment(department);
    }

    @PutMapping("/{departmentName}")
    public Department updateDepartment(@PathVariable String departmentName, @RequestBody Department department) {
        return departmentService.updateDepartment(departmentName, department);
    }

    @DeleteMapping("/{departmentName}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable String departmentName) {
        departmentService.deleteDepartment(departmentName);
        return ResponseEntity.noContent().build();
    }
}