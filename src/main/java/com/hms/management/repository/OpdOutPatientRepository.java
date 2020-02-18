package com.hms.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.OpdOutPatient;

public interface OpdOutPatientRepository extends JpaRepository<OpdOutPatient, Integer>{

	List<OpdOutPatient> findByPatientId(String patientId);

}
