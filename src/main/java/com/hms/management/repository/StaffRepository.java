package com.hms.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.Staff;

public interface StaffRepository extends JpaRepository<Staff, Integer>{

	public Object findByStaffId(String staffId);

}
