package com.example.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.model.Department;
import com.example.backend.repository.DepartmentRepository;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartment (String name) {
        Department temp = null;
        try {
            temp = departmentRepository.findById(name).get();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return temp;
    }

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department updateDepartment(String departmentName, Department updatedDepartment) {
        Optional<Department> optionalDepartment = departmentRepository.findById(departmentName);
        if (optionalDepartment.isPresent()) {
            Department department = optionalDepartment.get();
            department.setName(updatedDepartment.getName());
            return departmentRepository.save(department);
        }
        return null;
    }

    public void deleteDepartment(String departmentName) {
        departmentRepository.deleteById(departmentName);
    }
}
