package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.Staff;

public interface StaffRepo extends JpaRepository<Staff, Integer>{

}
