package com.hms.management.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.ComplainType;
import com.hms.management.repository.ComplainTypeRepository;
import com.hms.management.service.ComplainTypeService;

@Service
public class ComplainTypeServiceImpl implements ComplainTypeService{

	
	@Autowired
	public ComplainTypeRepository complainTypeRepository;

	@Override
	public ComplainType addComplainType(ComplainType complainType) {
 		return complainTypeRepository.save(complainType);
	}

	
	@Override
	public ComplainType getComplainType(int id) throws RecordNotFoundException {
	 return complainTypeRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("No ComplainType record exist for given id"));
	}
	@Override
	public List<ComplainType> getAllComplainType() throws RecordNotFoundException {
 		return complainTypeRepository.findAll();
	}
}
