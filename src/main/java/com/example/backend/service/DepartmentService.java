package com.example.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.model.Department;
import com.example.backend.model.Story;
import com.example.backend.repository.DepartmentRepository;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    public void init() {
        /*Department d1 = new Department("department1");
        Department d2 = new Department("department2");

        Story s1 = new Story("story1", "description1", d1);
        Story s2 = new Story("story2", "description2", d2);

        d1.getStories().add(s1);
        d2.getStories().add(s2);

        departmentRepository.save(d1);
        departmentRepository.save(d2);*/
    }

    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartment (String name) {
        init();
        Department temp = null;
        try {
            temp = departmentRepository.findById(name).get();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return temp;
    }
}
