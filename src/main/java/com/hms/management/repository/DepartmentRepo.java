package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.Department;

public interface DepartmentRepo extends JpaRepository<Department, Integer>{

}
