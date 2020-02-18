package com.hms.management.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.BloodDonor;
import com.hms.management.repository.BloodDonorRepository;
import com.hms.management.service.BloodDonorService;

@Service
public class BloodDonorServiceImpl implements BloodDonorService{

	
	@Autowired
	public BloodDonorRepository bloodDonorRepository;

	@Override
	public BloodDonor addBloodDonor(BloodDonor bloodDonor) {
		Date d=new Date();
		bloodDonor.setUpdatedAt(d);
		bloodDonor.setCreatedAt(d);
 		return bloodDonorRepository.save(bloodDonor);
	}

	@Override
	public BloodDonor getBloodDonor(int id) throws RecordNotFoundException {
 		return bloodDonorRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("no BloodDonor records for this id"));
	}

	@Override
	public List<BloodDonor> getAllBloodDonor() throws RecordNotFoundException {
 		return bloodDonorRepository.findAll();
	}
}
