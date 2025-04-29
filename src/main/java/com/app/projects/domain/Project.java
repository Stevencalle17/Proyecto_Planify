package com.app.projects.domain;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "projects")
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer team_id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Project() {
    }

    public Project(Long id, String name, String description, Integer team_id, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.team_id = team_id;
        this.createdAt = createdAt;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTeamId() {
        return team_id;
    }

    public void setTeamId(Integer team_id) {
        this.team_id = team_id;
    }

}