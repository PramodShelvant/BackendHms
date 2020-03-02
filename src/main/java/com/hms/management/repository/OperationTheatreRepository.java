package com.hms.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.OperationTheatre;

public interface OperationTheatreRepository extends JpaRepository<OperationTheatre, Integer>{

	List<OperationTheatre> findByPatientId(String patientId);

}
