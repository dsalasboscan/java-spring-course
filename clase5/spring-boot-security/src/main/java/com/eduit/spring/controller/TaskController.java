package com.eduit.spring.controller;

import com.eduit.spring.model.task.dto.TaskDto;
import com.eduit.spring.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ModelAndView home() {
        Map<String, List<TaskDto>> classifiedTasks = taskService.getTasksDividedByStatus();
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
        @ModelAttribute("tasks") Map<String, List<TaskDto>> classifiedTasks) {

        TaskDto savedTask = taskService.add(task);
        classifiedTasks.get("TO_DO").add(savedTask);
        return "redirect:/tasks";
    }

    @ModelAttribute("tasks")
    public Map<String, List<TaskDto>> createClassifiedTasksModel() {
        return taskService.getTasksDividedByStatus();
    }

    @ModelAttribute("task")
    public TaskDto createTaskModel(@ModelAttribute("task") TaskDto taskDto) {
        return taskDto;
    }
}
