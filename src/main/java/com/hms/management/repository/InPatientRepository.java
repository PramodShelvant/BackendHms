package com.hms.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.InPatient;

public interface InPatientRepository extends JpaRepository<InPatient, Integer>{

	List<InPatient> findByPatientId(String patientId);

	

}
