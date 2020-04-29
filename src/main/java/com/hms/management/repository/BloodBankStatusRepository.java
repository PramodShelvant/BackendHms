package com.hms.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.BloodBankStatus;

public interface BloodBankStatusRepository extends JpaRepository<BloodBankStatus, Integer>{

	public List<BloodBankStatus> findByBloodGroup(String bloodGroup);

	
}
