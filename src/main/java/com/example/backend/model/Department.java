package com.example.backend.model;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity(name = "Department")
@Table(name = "department")
public class Department {
    @Id
    private String name;
    @OneToMany(
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        mappedBy = "department"
    )
    @JsonIgnore
    private List<Story> stories;

    public Department() {}

    public Department(String name) {
        this.name = name;
        this.stories = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Story> getStories() {
        return stories;
    }

    public void setStories(List<Story> stories) {
        this.stories = stories;
    }

    @Override
    public String toString() {
        return "Department { name: " + name + "}";
    }
}