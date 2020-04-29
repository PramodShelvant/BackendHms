package com.hms.management.service;

import java.util.List;

import com.hms.management.model.PatientRegistration;

public interface PatientRegistrationService {

	
	public PatientRegistration addPatientRegistration(PatientRegistration patientRegistration);
 	public List<PatientRegistration> getAllPatientRegistration();
	public Object deletePatientRegistration(PatientRegistration patientRegistration);
	public PatientRegistration adPatientRegistration(PatientRegistration patientRegistration);

}
