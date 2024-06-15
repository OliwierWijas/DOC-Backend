package com.example.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.backend.model.Department;
import com.example.backend.model.Story;
import com.example.backend.repository.DepartmentRepository;
import com.example.backend.repository.StoryRepository;

@Service
@Transactional
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    StoryRepository storyRepository;

    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartment(String name) {
        Department temp = null;
        try {
            temp = departmentRepository.findById(name).get();
        } catch (Exception e) {
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
            Department returned = departmentRepository.save(updatedDepartment);
            List<Story> stories = department.getStories();
            for (Story story : stories) {
                story.setDepartment(department);
                storyRepository.save(story);
            }
            departmentRepository.deleteById(departmentName);
            return returned;
        }
        return null;
    }

    public void deleteDepartment(String departmentName) {
        departmentRepository.deleteById(departmentName);
    }
}
