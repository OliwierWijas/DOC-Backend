package com.example.backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/stories")
    public Story createStory(@RequestBody Story story) {
        return storyService.createStory(story);
    }

    @PutMapping("/{id}")
    public Story updateStory(@PathVariable int id, @RequestBody Story story) {
        return storyService.updateStory(id, story);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStory(@PathVariable int id) {
        storyService.deleteStory(id);
        return ResponseEntity.noContent().build();
    }
}
