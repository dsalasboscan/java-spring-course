package com.eduit.spring.model.task.dto;

import com.eduit.spring.model.DtoMapper;
import com.eduit.spring.model.task.Task;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DtoToTaskMapper implements DtoMapper<TaskDto, Task> {

    @Override
    public Task map(TaskDto taskDto) {
        LocalDateTime dueDate = parseDate(taskDto.getDueDate());
        return new Task(
                taskDto.getId(),
                taskDto.getTitle(),
                taskDto.getDescription(),
                dueDate,
                taskDto.getStatus()
        );
    }

    @Override
    public List<Task> map(List<TaskDto> taskDtoList) {
        return taskDtoList.stream().map(task ->
                new Task(
                        task.getId(),
                        task.getTitle(),
                        task.getDescription(),
                        LocalDateTime.parse(task.getDueDate()),
                        task.getStatus()))
                .collect(Collectors.toList());
    }

    private LocalDateTime parseDate(String dueDate) {
        DateTimeFormatter dateTimeFormatter =  DateTimeFormatter.ofPattern("MM/dd/yyyy K:mm a");
        return LocalDateTime.parse(dueDate, dateTimeFormatter);
    }
}