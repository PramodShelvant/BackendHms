package com.hms.management.service;

import java.util.List;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.ComplainType;

public interface ComplainTypeService {

	
	
	public ComplainType addComplainType(ComplainType complainType);
    public List<ComplainType> getAllComplainType() throws RecordNotFoundException;
	public ComplainType getComplainType(int id) throws RecordNotFoundException;
	public Object deleteComplainType(int id);
	public ComplainType adComplainType(ComplainType complainType);

}
