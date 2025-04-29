package com.app.projects.domain;

import java.util.List;

public interface IProjectService {
    
    List<Project> findAll();

    Project findById(Long id);

    Project save( Project project);

    Project update(Project project, Long id);

    void deleteById(Long id);
}
