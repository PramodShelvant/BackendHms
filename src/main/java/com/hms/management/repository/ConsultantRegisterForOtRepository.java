package com.hms.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.ConsultantRegisterForOt;

public interface ConsultantRegisterForOtRepository extends JpaRepository<ConsultantRegisterForOt, Integer>{

	public List<ConsultantRegisterForOt> findByPatientId(String patientId);

	
	
}
