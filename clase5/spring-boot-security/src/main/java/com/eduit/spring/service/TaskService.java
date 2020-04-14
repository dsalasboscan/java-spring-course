package com.eduit.spring.service;

import com.eduit.spring.model.task.dto.TaskDto;

import java.util.List;
import java.util.Map;

public interface TaskService {

    List<TaskDto> findAll();

    TaskDto add(TaskDto taskDto);

    Map<String, List<TaskDto>> getTasksDividedByStatus();

    void updateState(String status, Long id);

}
