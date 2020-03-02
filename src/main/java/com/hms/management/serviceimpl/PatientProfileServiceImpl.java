package com.hms.management.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.model.PatientProfile;
import com.hms.management.repository.PatientProfileRepository;
import com.hms.management.service.PatientProfileService;

@Service
public class PatientProfileServiceImpl implements PatientProfileService{

	
	@Autowired
	public PatientProfileRepository patientProfileRepository;
	
 	@Override
	public PatientProfile getPatientProfile(String patientId){
 		return patientProfileRepository.findByPatientId(patientId);
	}

	public PatientProfile addPatientProfile(PatientProfile patientProfile) {
 		return patientProfileRepository.save(patientProfile);
	}
	
}
