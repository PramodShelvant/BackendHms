package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.PatientCharges;

public interface PatientChargesRepo extends JpaRepository<PatientCharges, Integer>{

}
