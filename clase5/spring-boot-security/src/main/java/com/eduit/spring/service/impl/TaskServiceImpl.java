package com.eduit.spring.service.impl;

import com.eduit.spring.model.DtoMapper;
import com.eduit.spring.model.task.Task;
import com.eduit.spring.model.task.TaskStatus;
import com.eduit.spring.model.task.dto.TaskDto;
import com.eduit.spring.repository.TaskRepository;
import com.eduit.spring.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    private DtoMapper<TaskDto, Task> dtoToTaskMapper;
    private DtoMapper<Task, TaskDto> taskToDtoMapper;

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
    public Map<String, List<TaskDto>> getTasksDividedByStatus() {
        Map<String, List<TaskDto>> tasksByStatus = new HashMap<>();
        List<Task> tasks = taskRepository.findAll();

        addToTaskByStatusMap(tasksByStatus, tasks, TaskStatus.TO_DO.name());
        addToTaskByStatusMap(tasksByStatus, tasks, TaskStatus.IN_PROGRESS.name());
        addToTaskByStatusMap(tasksByStatus, tasks, TaskStatus.DONE.name());

        return tasksByStatus;
    }

    @Override
    @Transactional
    public void updateState(String status, Long id) {
        taskRepository.updateStatus(status, id);

    }

    @Override
    public TaskDto add(TaskDto taskDto) {
        Task task = dtoToTaskMapper.map(taskDto);
        task.setStatus(TaskStatus.TO_DO.name());

        taskRepository.save(task);

        return taskToDtoMapper.map(task);
    }

    private void addToTaskByStatusMap(Map<String, List<TaskDto>> tasksByStatus, List<Task> tasks, String taskStatus) {
        tasksByStatus.put(taskStatus, taskToDtoMapper.map(classifyTask(tasks, taskStatus)));
    }

    private List<Task> classifyTask(List<Task> tasks, String taskStatus) {
        List<Task> classifiedTasks = new ArrayList<>();

        tasks.forEach(task -> {
            if (task.getStatus().equalsIgnoreCase(taskStatus)) {
                classifiedTasks.add(task);
            }
        });

        return classifiedTasks;
    }
}
