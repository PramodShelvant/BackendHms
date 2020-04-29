package com.hms.management.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.model.BloodDonorCycle;
import com.hms.management.repository.BloodDonorCycleRepository;
import com.hms.management.service.BloodDonorCycleService;

@Service
public class BloodDonorCycleServiceImpl implements BloodDonorCycleService{

	
	@Autowired
	public BloodDonorCycleRepository bloodDonorCycleRepository;

	@Override
	public BloodDonorCycle addBloodDonor(BloodDonorCycle BloodDonorCycle) {
 		return bloodDonorCycleRepository.save(BloodDonorCycle);
	}

	@Override
	public Iterable<BloodDonorCycle> getAll() {
 		return bloodDonorCycleRepository.findAll();
	}

	@Override
	public Optional<BloodDonorCycle> getByBloodDonorCycle(int id) {
 		return bloodDonorCycleRepository.findById(id);
	}

	@Override
	public String deleteBloodDonorCycle(int id) {
		bloodDonorCycleRepository.deleteById(id);
 		return "record deleted succesfully";
	}
}
