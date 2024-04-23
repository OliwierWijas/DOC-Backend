package com.example.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.backend.model.Story;

public interface StoryRepository extends JpaRepository <Story, Integer>{
    @Query("SELECT s FROM Story s WHERE s.department.name = :departmentName")
    List<Story> findByDepartmentName(@Param("departmentName") String departmentName);
}