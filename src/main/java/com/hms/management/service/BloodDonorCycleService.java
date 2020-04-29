package com.hms.management.service;

import java.util.Optional;

import com.hms.management.model.BloodDonorCycle;

public interface BloodDonorCycleService {

	
	public BloodDonorCycle addBloodDonor(BloodDonorCycle BloodDonorCycle);
	public Iterable<BloodDonorCycle> getAll();
	public String deleteBloodDonorCycle(int id);
	public Optional<BloodDonorCycle> getByBloodDonorCycle(int id);
}
