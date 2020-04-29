package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.SendNotification;

public interface SendNotificationRepo extends JpaRepository<SendNotification, Integer> {

}
