package com.hms.management.service;

import java.util.List;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.InPatient;

public interface InPatientService {

	
	public InPatient addInPatient(InPatient inPatient) throws RecordNotFoundException;
 	public List<InPatient> getAllInPatient() throws RecordNotFoundException;
 	public Object deleteInPatient(int id);
  	public Object getAll();
	public InPatient updateIpdDisCharge(InPatient inPatient);
	public Object getByDoctorId(String doctorId, String disChargeStatus);
	public Object getByDisChargeStatus(String disChargeStatus);
 //	public Object getInPatient(String patientId);
	Object getInPatient(String patientId, String status);


}
