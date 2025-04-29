package com.app.projects.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.app.projects.domain.IProjectRepository;
import com.app.projects.domain.Project;

@Component
public class ProjectDatasource {

    private final IProjectRepository projectRepository;

    public ProjectDatasource(IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> findAll() {
        return projectRepository.findAll();
    }
    public Optional<Project> findById(Long id) {
        return projectRepository.findById(id);
    }

    public Project save(Project project) {
        return projectRepository.save(project);
    }

    public Optional<Project> update(Project project, Long id) {
        return projectRepository.findById(id).map(existingProject -> {
            existingProject.setName(project.getName());
            existingProject.setTeam_id(project.getTeam_id());
            return projectRepository.save(existingProject);
        });
    }

    public boolean deleteById(Long id) {
        if (projectRepository.existsById(id)) {
            projectRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
