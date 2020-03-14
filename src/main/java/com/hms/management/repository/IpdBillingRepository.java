package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.IpdBilling;

public interface IpdBillingRepository extends JpaRepository<IpdBilling, Integer>{

	public IpdBilling findByPatientId(String patientId);

}
