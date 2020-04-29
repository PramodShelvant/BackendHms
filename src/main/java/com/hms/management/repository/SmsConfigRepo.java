package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.SmsConfig;

public interface SmsConfigRepo extends JpaRepository<SmsConfig, Integer> {

}
