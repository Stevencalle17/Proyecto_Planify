package com.app.projects.adapters;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.projects.domain.IProjectService;
import com.app.projects.domain.Project;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    
    private final IProjectService projectService;

    public ProjectController(IProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<Project> findAll() {
        return projectService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> findById(@PathVariable Long id) {
        return ResponseEntity.ok(projectService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Project> save(@RequestBody Project project) {
        return ResponseEntity.ok(projectService.save(project));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> update(@RequestBody Project project, @PathVariable Long id) {
        return ResponseEntity.ok(projectService.update(project, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        projectService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}