package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.PatientAddress;

public interface PatientAddressRepo extends JpaRepository<PatientAddress, Integer>{

}
