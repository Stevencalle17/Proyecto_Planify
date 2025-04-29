package com.app.projects.infrastructure;

import java.time.LocalDateTime;

public class ProjectDto {
    private Long id;
    private String name;
    private Integer team_id;
    private String description;
    private LocalDateTime createdAt;

    public ProjectDto() {
    }

    public ProjectDto(Long id, String name, Integer team_id, String description, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.team_id = team_id;
        this.description = description;
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

    public Integer getTeam_id() {
        return team_id;
    }

    public void setTeam_id(Integer team_id) {
        this.team_id = team_id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", team_id='" + team_id + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
