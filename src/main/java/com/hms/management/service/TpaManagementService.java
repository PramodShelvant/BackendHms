package com.hms.management.service;

import java.util.List;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.TpaManagement;

public interface TpaManagementService {
	
	public TpaManagement addTpaManagement(TpaManagement tpaManagement);

	public TpaManagement getTpaManagement(int id) throws RecordNotFoundException;

	public List<TpaManagement> getAllTpaManagement() throws RecordNotFoundException;

	public Object deleteTpaManagement(int id);

}
