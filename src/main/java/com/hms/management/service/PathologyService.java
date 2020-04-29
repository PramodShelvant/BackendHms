package com.hms.management.service;

import java.util.List;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.Pathology;

public interface PathologyService {
	
	
	public Pathology addPathology(Pathology pathology) throws RecordNotFoundException;
	public Pathology getPathology(int id) throws RecordNotFoundException;
	public List<Pathology> getAllPathology();
	public Pathology getByPatientid(String patientId);
	public Object deletePathology(int id);



}
