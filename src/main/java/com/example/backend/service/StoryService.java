package com.example.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.model.Story;
import com.example.backend.repository.StoryRepository;

@Service
public class StoryService {
    @Autowired
    StoryRepository storyRepository;

    public List<Story> getStoriesForDepartment(String departmentName) {
        return storyRepository.findByDepartmentName(departmentName);
    }
}
