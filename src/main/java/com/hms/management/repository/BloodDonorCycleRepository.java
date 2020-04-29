package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.BloodDonorCycle;

public interface BloodDonorCycleRepository extends JpaRepository<BloodDonorCycle, Integer>{

	public BloodDonorCycle findByBloodDonorId(String bloodDonorId);

}
