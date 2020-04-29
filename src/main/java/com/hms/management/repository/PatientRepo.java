package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.Patient;

public interface PatientRepo extends JpaRepository<Patient, Integer> {

}
