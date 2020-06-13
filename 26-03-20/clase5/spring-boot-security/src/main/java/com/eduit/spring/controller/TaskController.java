package com.eduit.spring.controller;

import com.eduit.spring.model.task.dto.TaskDto;
import com.eduit.spring.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(value = {"/", "/tasks"})
    public ModelAndView home(Authentication authentication) {
        Map<String, List<TaskDto>> classifiedTasks = taskService.getTasksDividedByStatus(authentication);
        ModelAndView modelAndView = new ModelAndView("tasks");
        modelAndView.addObject("tasks", classifiedTasks);
        return modelAndView;
    }

    @GetMapping(value = "/task/transition/{taskId}")
    public String updateTask(@RequestParam("status") String status, @PathVariable("taskId") Long taskId) {
        taskService.updateState(status, taskId);
        return "redirect:/tasks";
    }

    @GetMapping(value = "/task/add")
    public String addTask() {
        return "taskAdd";
    }

    @PostMapping(value = "/task/add")
    public String addTask(
        @ModelAttribute("task") TaskDto task,
        @ModelAttribute("tasks") Map<String, List<TaskDto>> classifiedTasks,
        Authentication authentication) {

        if (authentication != null) {
            TaskDto savedTask = taskService.add(task, authentication.getName());
            classifiedTasks.get("TO_DO").add(savedTask);
            return "redirect:/tasks";
        }

        return "redirect:/login";
    }

    @ModelAttribute("tasks")
    public Map<String, List<TaskDto>> createClassifiedTasksModel(Authentication authentication) {
        return taskService.getTasksDividedByStatus(authentication);
    }

    @ModelAttribute("task")
    public TaskDto createTaskModel(@ModelAttribute("task") TaskDto taskDto) {
        return taskDto;
    }
}
