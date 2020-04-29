package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.MedicineCategory;

public interface MedicineCategoryRepo extends JpaRepository<MedicineCategory, Integer>{

}
