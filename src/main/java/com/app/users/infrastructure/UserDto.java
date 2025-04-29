package com.app.users.infrastructure;

import java.time.LocalDateTime;

public class UserDto {
    private Long id;
    private String name;
    private String email;
    private Long teamId;
    private Long planId;
    private LocalDateTime createdAt;

    public UserDto() {}

    public UserDto(Long id, String name, String email, Long teamId, Long planId, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.teamId = teamId;
        this.planId = planId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
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
                ", email='" + email + '\'' +
                ", teamId=" + teamId +
                ", planId=" + planId +
                ", createdAt=" + createdAt +
                '}';
    }
}
