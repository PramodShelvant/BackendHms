package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.ReadNotification;

public interface ReadNotificationRepo extends JpaRepository<ReadNotification, Integer> {

}
