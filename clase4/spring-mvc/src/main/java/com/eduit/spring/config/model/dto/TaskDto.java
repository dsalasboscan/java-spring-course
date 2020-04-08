package com.eduit.spring.config.model.dto;

import java.util.Objects;

public class TaskDto {
    private Long id;

    private String title;

    private String description;

    private String dueDate;

    private String status;

    private String transitionStatus;

    public TaskDto() {}

    public TaskDto(Long id, String title, String description, String dueDate, String status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransitionStatus() {
        return transitionStatus;
    }

    public void setTransitionStatus(String transitionStatus) {
        this.transitionStatus = transitionStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskDto taskDto = (TaskDto) o;
        return Objects.equals(id, taskDto.id) &&
                Objects.equals(title, taskDto.title) &&
                Objects.equals(description, taskDto.description) &&
                Objects.equals(dueDate, taskDto.dueDate) &&
                Objects.equals(status, taskDto.status) &&
                Objects.equals(transitionStatus, taskDto.transitionStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, dueDate, status, transitionStatus);
    }

    @Override
    public String toString() {
        return "TaskDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", status='" + status + '\'' +
                ", transitionStatus='" + transitionStatus + '\'' +
                '}';
    }
}
