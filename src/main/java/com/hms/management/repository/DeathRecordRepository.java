package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.DeathRecord;

public interface DeathRecordRepository extends JpaRepository<DeathRecord, Integer>{

}
