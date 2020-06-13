package com.eduit.spring.service;

import com.eduit.spring.model.task.dto.TaskDto;
import org.springframework.security.core.Authentication;

import java.util.List;
import java.util.Map;

public interface TaskService {

    List<TaskDto> findAll();

    TaskDto add(TaskDto taskDto, String email);

    Map<String, List<TaskDto>> getTasksDividedByStatus(Authentication authentication);

    void updateState(String status, Long id);

}
