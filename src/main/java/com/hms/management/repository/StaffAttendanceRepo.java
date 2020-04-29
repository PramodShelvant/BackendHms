package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.StaffAttendance;

public interface StaffAttendanceRepo extends JpaRepository<StaffAttendance, Integer> {

}
