package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.Diagnosis;

public interface DiagnosisRepo extends JpaRepository<Diagnosis, Integer>{

}
