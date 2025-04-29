package com.app.tasks.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.shared.adapters.exception.ResourceNotFoundException;

import com.app.tasks.domain.ITaskRepository;
import com.app.tasks.domain.ITaskService;
import com.app.tasks.domain.Task;

@Service
public class TaskService implements ITaskService {

    private final ITaskRepository taskRepository;

    public TaskService(ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task findById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with ID: " + id));
    }

    @Override
    @Transactional
    public Task save(Task task) {
        if (taskRepository.existsByTitle(task.getTitle())) {
            throw new IllegalArgumentException("Task title already exists: " + task.getTitle());
        }
        return taskRepository.save(task);
    }

    @Override
    @Transactional
    public Task update(Task task, Long id) {
        Task existingTask = findById(id);
        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        return taskRepository.save(existingTask);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Task task = findById(id);
        taskRepository.delete(task);
    }
}
