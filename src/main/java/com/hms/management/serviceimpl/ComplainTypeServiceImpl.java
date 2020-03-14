package com.hms.management.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


	@Override
	public Object deleteComplainType(int id) {
		Map<String, Object> map=new HashMap<>();
		complainTypeRepository.deleteById(id);
		map.put("status", 1);
 		return map;
	}

   @Override
	public ComplainType adComplainType(ComplainType complainType) {
 		return complainTypeRepository.save(complainType);
	}
}
