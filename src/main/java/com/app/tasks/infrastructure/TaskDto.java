package com.app.tasks.infrastructure;

public class TaskDto {
    private Long id;
    private String title;
    private String description;
    private String project;
    private String assigned;
    private String state;

    public TaskDto() {
    }

    public TaskDto(Long id, String title, String description, String project, String assigned, String state) {
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
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getAssigned() {
        return assigned;
    }

    public void setAssigned(String assigned) {
        this.assigned = assigned;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "TaskDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", project='" + project + '\'' +
                ", assigned='" + assigned + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
