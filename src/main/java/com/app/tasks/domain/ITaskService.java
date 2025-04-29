package com.app.tasks.domain;

import java.util.List;

public interface ITaskService {
    
    List<Task> findAll();

    Task findById(Long id);

    Task save(Task task);

    Task update(Task task, Long id);

    void deleteById(Long id);
}
