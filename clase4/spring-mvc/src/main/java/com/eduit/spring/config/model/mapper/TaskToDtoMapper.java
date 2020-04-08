package com.eduit.spring.config.model.mapper;

import com.eduit.spring.config.model.Task;
import com.eduit.spring.config.model.dto.TaskDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskToDtoMapper implements DtoMapper<Task, TaskDto> {

    @Override
    public TaskDto map(Task task) {
        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                this.localDateTimeToString(task.getDueDate()),
                task.getStatus()
        );
    }

    @Override
    public List<TaskDto> map(List<Task> tasks) {
        return tasks.stream().map(task ->
                new TaskDto(
                        task.getId(),
                        task.getTitle(),
                        task.getDescription(),
                        this.localDateTimeToString(task.getDueDate()),
                        task.getStatus()))
                .collect(Collectors.toList());
    }

    private String localDateTimeToString(LocalDateTime dueDate) {
        DateTimeFormatter dateTimeFormatter =  DateTimeFormatter.ofPattern("MM/dd/yyyy K:mm a");
        return dueDate.format(dateTimeFormatter);
    }
}
