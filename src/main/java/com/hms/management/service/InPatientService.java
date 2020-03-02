package com.hms.management.service;

import java.util.List;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.InPatient;

public interface InPatientService {

	
	public InPatient addInPatient(InPatient inPatient) throws RecordNotFoundException;
 	public List<InPatient> getAllInPatient() throws RecordNotFoundException;
	public Object getInPatient(String patientId) throws RecordNotFoundException;
	public Object deleteInPatient(int id);


}
