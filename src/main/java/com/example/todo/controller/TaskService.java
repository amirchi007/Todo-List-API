package com.example.todo.controller;

import com.example.todo.model.Task;
import com.example.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Task getTaskById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public Task createTask(Task task) {
        return repository.save(task);
    }

    public Task updateTask(Long id, Task task) {
        Task existing = getTaskById(id);
        existing.setTitle(task.getTitle());
//        existing.setDescription(task.getDescription());
//        existing.setCompleted(task.isCompleted());
        return repository.save(existing);
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }
}
