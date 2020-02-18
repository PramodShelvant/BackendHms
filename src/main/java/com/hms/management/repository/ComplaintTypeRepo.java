package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.ComplaintType;

public interface ComplaintTypeRepo extends JpaRepository<ComplaintType, Integer>{

}
