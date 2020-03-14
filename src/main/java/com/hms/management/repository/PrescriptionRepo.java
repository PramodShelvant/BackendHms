package com.hms.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.Prescription;

public interface PrescriptionRepo extends JpaRepository<Prescription, Integer>{

	public List<Prescription> findByOpdId(String opdId);

}
