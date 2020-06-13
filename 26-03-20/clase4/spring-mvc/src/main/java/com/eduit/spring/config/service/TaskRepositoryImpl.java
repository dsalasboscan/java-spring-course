package com.eduit.spring.config.service;

import com.eduit.spring.config.model.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepositoryImpl implements TaskRepository {

    private static final String GET_ALL_TASKS_QUERY = "SELECT a FROM Task a";

    private SessionFactory sessionFactory;

    public TaskRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Task> findAll() {
        List<Task> tasks = new ArrayList<>();

        Session session = sessionFactory.getCurrentSession();

        TypedQuery<Task> query = session.createQuery(GET_ALL_TASKS_QUERY, Task.class);

        try {
            tasks.addAll(query.getResultList());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tasks;
    }

    @Override
    @Transactional
    public void add(Task task) {
        Session session = sessionFactory.getCurrentSession();

        try {
            session.persist(task);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    @Transactional
    public void update(Task task) {
        Session session = sessionFactory.getCurrentSession();

        try {
            session.update(task);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
