package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.PathologyCategory;

public interface PathologyCategoryRepo extends JpaRepository<PathologyCategory, Integer>{

}
