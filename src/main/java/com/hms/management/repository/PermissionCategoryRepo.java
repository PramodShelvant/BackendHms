package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.PermissionCategory;

public interface PermissionCategoryRepo extends JpaRepository<PermissionCategory, Integer>{

}
