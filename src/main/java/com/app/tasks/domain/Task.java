package com.app.tasks.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tasks")
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, unique = true)
    private String description;

    @Column(nullable = false)
    private String project;

    @Column(nullable = false)
    private String assigned;

    @Column(nullable = false)
    private String state;

    public Task() {
    }

    public Task(Long id, String title, String description, String project, String assigned, String state) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.project = project;
        this.assigned = assigned;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProject() {
        return this.project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getAssigned() {
        return this.assigned;
    }

    public void setAssigned(String assigned) {
        this.assigned = assigned;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }
}