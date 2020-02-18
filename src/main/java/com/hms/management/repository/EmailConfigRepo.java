package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.EmailConfig;

public interface EmailConfigRepo extends JpaRepository<EmailConfig, Integer>{

}
