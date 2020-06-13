package com.eduit.spring.config.service;

import com.eduit.spring.config.model.Task;

import java.util.List;

public interface TaskRepository {

    List<Task> findAll();

    void add(Task task);

    void update(Task task);
}
