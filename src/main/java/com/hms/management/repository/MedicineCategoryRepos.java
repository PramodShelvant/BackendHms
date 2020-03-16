package com.hms.management.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hms.management.model.MedicineCategoryModal;

public interface MedicineCategoryRepos extends JpaRepository<MedicineCategoryModal,Integer> {
	
}
