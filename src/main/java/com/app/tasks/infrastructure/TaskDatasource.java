package com.app.tasks.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.app.tasks.domain.ITaskRepository;
import com.app.tasks.domain.Task;

@Component
public class TaskDatasource {

    private final ITaskRepository taskRepository;

    public TaskDatasource(ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    public Task save(Task task) {
        return taskRepository.save(task);
    }

    public Optional<Task> update(Task task, Long id) {
        return taskRepository.findById(id).map(existingTask -> {
            existingTask.setTitle(task.getTitle());
            existingTask.setDescription(task.getDescription());
            existingTask.setProject(task.getProject());
            existingTask.setAssigned(task.getAssigned());
            existingTask.setState(task.getState());
            return taskRepository.save(existingTask);
        });
    }
    public boolean deleteById(Long id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
