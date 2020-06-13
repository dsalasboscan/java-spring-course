package com.eduit.spring.config.controller;

import com.eduit.spring.config.model.dto.TaskDto;
import com.eduit.spring.config.service.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("tasks")
public class TaskController {

    private TaskServiceImpl taskService;

    @Autowired
    public TaskController(TaskServiceImpl taskService) {
        this.taskService = taskService;
    }

    @GetMapping(value = "/")
    public ModelAndView home() {
        Map<String, List<TaskDto>> classifiedTasks = taskService.getTasksDividedByStatus();
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("tasks", classifiedTasks);

        return modelAndView;
    }

    @PostMapping(value = "/task/transition")
    public String updateTask(@ModelAttribute("task") TaskDto taskDto) {
        taskService.updateState(taskDto);
        return "redirect:/";
    }

    @PostMapping(value = "/task/add")
    public String saveTask(@ModelAttribute("task") TaskDto taskDto, @ModelAttribute("tasks") Map<String, List<TaskDto>> classifiedTasks) {
        TaskDto savedTask = taskService.add(taskDto);
        classifiedTasks.get("TO_DO").add(savedTask);

        return "redirect:/";
    }

    @ModelAttribute("task")
    public TaskDto createTaskModel(@ModelAttribute("task") TaskDto taskDto, HttpServletRequest request) {
        taskDto.setTransitionStatus(request.getParameter("transitionStatus"));
        return taskDto;
    }

    @ModelAttribute("tasks")
    public Map<String, List<TaskDto>> createClassifiedTasksModel() {
        return taskService.getTasksDividedByStatus();
    }

}
