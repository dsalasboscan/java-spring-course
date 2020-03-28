package com.eduit.spring.repository;

import com.eduit.spring.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Long, Message> {
}
