package com.example.backend;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.backend.model.*;

public class DepartmentTest {

    private Department department;

    @BeforeEach
    public void setUp() {
        department = new Department("Test Department");
    }

    @Test
    public void testGetName() {
        assertEquals("Test Department", department.getName());
    }

    @Test
    public void testGetStories() {
        List<Story> stories = new ArrayList<>();
        Story story1 = mock(Story.class);
        Story story2 = mock(Story.class);
        stories.add(story1);
        stories.add(story2);

        department.setStories(stories);

        assertEquals(2, department.getStories().size());
        assertTrue(department.getStories().contains(story1));
        assertTrue(department.getStories().contains(story2));
    }

    @Test
    public void testToString() {
        assertEquals("Department { name: Test Department}", department.toString());
    }
}
