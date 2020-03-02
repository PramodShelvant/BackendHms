package com.hms.management.service;

import java.util.List;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.OperationTheatre;

public interface OperationTheatreService {
	
	public OperationTheatre addOperationTheatre(OperationTheatre operationTheatre);
	public OperationTheatre getByIdOperationTheatre(int id) throws RecordNotFoundException;
	public List<OperationTheatre> getAllOperationTheatre();
	public Object deleteOperationTheatre(int id);
	public List<OperationTheatre> getByPatientId(String patientId);


}
