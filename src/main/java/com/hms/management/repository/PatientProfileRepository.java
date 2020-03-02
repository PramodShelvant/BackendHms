package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.PatientProfile;

public interface PatientProfileRepository extends JpaRepository<PatientProfile, Integer>{

 
	public PatientProfile findByPatientId(String patientId);

}
