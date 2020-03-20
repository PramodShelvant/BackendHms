package com.hms.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.MedicineBadStock;

public interface MedicineBadStockRepo extends JpaRepository<MedicineBadStock, Integer>{

	List<MedicineBadStock> findByPharmacyId(int id);

}
