package com.hms.management.service;

import java.util.List;

import com.hms.management.model.Prescription;

public interface PrescriptionService {

	
	public Prescription addPrescription(Prescription prescription);

 
	List<Prescription> getPrescription(String opdId);
}
