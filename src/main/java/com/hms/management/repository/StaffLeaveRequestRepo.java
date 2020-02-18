package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.StaffLeaveRequest;

public interface StaffLeaveRequestRepo  extends JpaRepository<StaffLeaveRequest, Integer>{

}
