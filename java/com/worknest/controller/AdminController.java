package com.worknest.controller;

import com.worknest.entity.Task;
import com.worknest.entity.User;
import com.worknest.service.TaskService;
import com.worknest.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final TaskService taskService;
    private final UserService userService;

    public AdminController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        return "admin-dashboard";
    }

    @GetMapping("/add-task")
    public String addTaskForm(Model model) {
        model.addAttribute("task", new Task());
        model.addAttribute("users", userService.findAll());
        return "add-task";
    }

    @PostMapping("/add-task")
    public String saveTask(@ModelAttribute Task task) {
        taskService.save(task);
        return "redirect:/admin/dashboard";
    }
}
