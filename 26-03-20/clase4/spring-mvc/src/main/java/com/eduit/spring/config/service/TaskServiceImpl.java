package com.eduit.spring.config.service;

import com.eduit.spring.config.model.Task;
import com.eduit.spring.config.model.TaskStatus;
import com.eduit.spring.config.model.dto.TaskDto;
import com.eduit.spring.config.model.mapper.DtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    private final DtoMapper<TaskDto, Task> dtoToTaskMapper;

    private final DtoMapper<Task, TaskDto> taskToDtoMapper;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, DtoMapper<TaskDto, Task> dtoToTaskMapper, DtoMapper<Task, TaskDto> taskToDtoMapper) {
        this.taskRepository = taskRepository;
        this.dtoToTaskMapper = dtoToTaskMapper;
        this.taskToDtoMapper = taskToDtoMapper;
    }

    @Override
    public List<TaskDto> findAll() {
        List<Task> tasks = taskRepository.findAll();
        return taskToDtoMapper.map(tasks);
    }

    @Override
    public TaskDto add(TaskDto taskDto) {
        Task task = dtoToTaskMapper.map(taskDto);
        task.setStatus(TaskStatus.TO_DO.name());
        taskRepository.add(task);

        return taskToDtoMapper.map(task);
    }

    @Override
    public Map<String, List<TaskDto>> getTasksDividedByStatus() {
        Map<String, List<TaskDto>> tasksByStatus = new HashMap<>();
        List<Task> tasks = taskRepository.findAll();

        addTasksToMap(tasksByStatus, tasks, TaskStatus.TO_DO.name());
        addTasksToMap(tasksByStatus, tasks, TaskStatus.IN_PROGRESS.name());
        addTasksToMap(tasksByStatus, tasks, TaskStatus.DONE.name());

        return tasksByStatus;
    }

    @Override
    public void updateState(TaskDto taskDto) {
        Task task = dtoToTaskMapper.map(taskDto);
        task.setStatus(taskDto.getTransitionStatus());
        taskRepository.update(task);
    }

    private void addTasksToMap(Map<String, List<TaskDto>> tasksByStatus, List<Task> tasks, String taskStatus) {
        tasksByStatus.put(taskStatus, taskToDtoMapper.map(classifyTasks(tasks, taskStatus)));
    }

    private List<Task> classifyTasks(List<Task> tasks, String status) {
        List<Task> classifiedTasks = new ArrayList<>();

        tasks.forEach(task -> {
            if (task.getStatus().equals(status)) {
                classifiedTasks.add(task);
            }
        });

        return classifiedTasks;
    }
}
