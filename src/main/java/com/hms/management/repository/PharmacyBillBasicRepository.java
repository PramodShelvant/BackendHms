package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.PharmacyBillBasic;

public interface PharmacyBillBasicRepository extends JpaRepository<PharmacyBillBasic, Integer>{

	public PharmacyBillBasic findByPatientId(String patientId);

}
