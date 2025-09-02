package com.worknest.controller;

import com.worknest.entity.User;
import com.worknest.service.TaskService;
import com.worknest.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    private final TaskService taskService;
    private final UserRepository userRepo;

    public UserController(TaskService taskService, UserRepository userRepo) {
        this.taskService = taskService;
        this.userRepo = userRepo;
    }

    @GetMapping("/tasks")
    public String tasks(Authentication auth, Model model) {
        User user = userRepo.findByUsername(auth.getName()).orElseThrow();
        model.addAttribute("tasks", taskService.getTasksForUser(user));
        return "user-tasks";
    }
}
