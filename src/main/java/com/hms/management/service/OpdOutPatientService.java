package com.hms.management.service;

import java.util.List;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.OpdOutPatient;
 
public interface OpdOutPatientService {

	
	public OpdOutPatient addOutPatient(OpdOutPatient opdOutPatient) throws RecordNotFoundException;
  	public List<OpdOutPatient> getAllOpdOutPatient() throws RecordNotFoundException;
	public OpdOutPatient getOpdOutPatientById(int id) throws RecordNotFoundException;
	public Object getByPatientId(String patientId);
	public Object deleteOpdOutPatient(int id);
	public Object getByDId(String doctorId);



}
