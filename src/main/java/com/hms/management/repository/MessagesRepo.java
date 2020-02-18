package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.Messages;

public interface MessagesRepo extends JpaRepository<Messages, Integer>{

}
