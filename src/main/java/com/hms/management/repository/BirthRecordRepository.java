package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.BirthRecord;

public interface BirthRecordRepository extends JpaRepository<BirthRecord, Integer>{

}
