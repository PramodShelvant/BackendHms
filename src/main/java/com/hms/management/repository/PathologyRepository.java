package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.Pathology;

public interface PathologyRepository extends JpaRepository<Pathology, Integer>{

	Pathology findByPatientId(String patientId);

 }
