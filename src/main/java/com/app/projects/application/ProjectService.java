package com.app.projects.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.projects.domain.IProjectRepository;
import com.app.projects.domain.IProjectService;
import com.app.projects.domain.Project;
import com.app.shared.adapters.exception.ResourceNotFoundException;

@Service
public class ProjectService implements IProjectService {

    private final IProjectRepository projectRepository;

    public ProjectService(IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project findById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with ID: " + id));
    }

    @Override
    @Transactional
    public Project save(Project project) {
        if (projectRepository.existsByName(project.getName())) {
            throw new IllegalArgumentException("Project name already exists: " + project.getName());
        }
        return projectRepository.save(project);
    }

    @Override
    @Transactional
    public Project update(Project project, Long id) {
        Project existingProject = findById(id);
        existingProject.setName(project.getName());
        return projectRepository.save(existingProject);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Project project = findById(id);
        projectRepository.delete(project);
    }
}
