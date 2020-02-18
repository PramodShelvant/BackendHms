package com.hms.management.service;

import java.util.List;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.OpdOutPatient;
 
public interface OpdOutPatientService {

	
	public OpdOutPatient addOutPatient(OpdOutPatient opdOutPatient) throws RecordNotFoundException;
  	public List<OpdOutPatient> getAllOpdOutPatient() throws RecordNotFoundException;
	OpdOutPatient getOpdOutPatientById(int id) throws RecordNotFoundException;
	List<OpdOutPatient> getByPatientId(String patientId);



}
