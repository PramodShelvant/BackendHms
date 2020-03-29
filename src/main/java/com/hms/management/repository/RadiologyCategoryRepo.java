package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.RadiologyCategory;

public interface RadiologyCategoryRepo extends JpaRepository<RadiologyCategory, Integer> {

}
