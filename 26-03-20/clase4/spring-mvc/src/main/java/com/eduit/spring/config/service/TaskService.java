package com.eduit.spring.config.service;

import com.eduit.spring.config.model.dto.TaskDto;

import java.util.List;
import java.util.Map;

public interface TaskService {

    List<TaskDto> findAll();

    TaskDto add(TaskDto taskDto);

    Map<String, List<TaskDto>> getTasksDividedByStatus();

    void updateState(TaskDto taskDto);
}
