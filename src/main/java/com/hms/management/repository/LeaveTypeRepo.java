package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.LeaveType;

public interface LeaveTypeRepo extends JpaRepository<LeaveType, Integer> {

}
