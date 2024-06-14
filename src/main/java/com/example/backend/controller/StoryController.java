package com.example.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.model.Story;
import com.example.backend.service.StoryService;

@RestController
public class StoryController {
    private StoryService storyService;
    
    public StoryController(StoryService storyService) {
        this.storyService = storyService;
    }
    
    @GetMapping("/stories")
    public List<Story> getStoriesForDepartment(@RequestParam(name = "departmentName", required = false) String departmentName) {
        if (departmentName == null) {
            return storyService.getStories();
        }
        return storyService.getStoriesForDepartment(departmentName);
    }
}
