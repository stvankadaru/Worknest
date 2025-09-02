package com.worknest.service;

import com.worknest.entity.Task;
import com.worknest.entity.User;
import com.worknest.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepo;

    public TaskService(TaskRepository taskRepo) {
        this.taskRepo = taskRepo;
    }

    public Task save(Task task) {
        return taskRepo.save(task);
    }

    public List<Task> getTasksForUser(User user) {
        return taskRepo.findByAssignedTo(user);
    }

    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }
}
