package com.hms.management.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.model.Prescription;
import com.hms.management.repository.PrescriptionRepo;
import com.hms.management.service.PrescriptionService;

@Service
public class PrescriptionServiceImpl implements PrescriptionService{

	
	
	@Autowired
	public PrescriptionRepo prescriptionRepository;

	@Override
	public Prescription addPrescription(Prescription prescription) {
		Date d=new Date();
		prescription.setDate(d);
 		return prescriptionRepository.save(prescription);
	}

	@Override
	public List<Prescription> getPrescription(String opdId) {
		
 		return prescriptionRepository.findByOpdId(opdId);
	}
}
