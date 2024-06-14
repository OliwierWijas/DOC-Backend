package com.example.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.model.Story;
import com.example.backend.repository.StoryRepository;

@Service
public class StoryService {
    @Autowired
    StoryRepository storyRepository;

    public List<Story> getStories() {
        return storyRepository.findAll();
    }

    public List<Story> getStoriesForDepartment(String departmentName) {
        return storyRepository.findByDepartmentName(departmentName);
    }

    public Story createStory(Story story) {
        return storyRepository.save(story);
    }

    public Story updateStory(int id, Story updatedStory) {
        Optional<Story> optionalStory = storyRepository.findById(id);
        if (optionalStory.isPresent()) {
            Story story = optionalStory.get();
            story.setTitle(updatedStory.getTitle());
            story.setDescription(updatedStory.getDescription());
            story.setDepartment(updatedStory.getDepartment());
            return storyRepository.save(story);
        }
        return null;
    }

    public void deleteStory(int id) {
        storyRepository.deleteById(id);
    }
}
