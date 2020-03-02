package com.hms.management.serviceimpl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.TpaManagement;
import com.hms.management.repository.TpaManagementRepository;
import com.hms.management.service.TpaManagementService;

@Service
public class TpaManagementServiceImpl implements TpaManagementService{

	
	@Autowired
	public TpaManagementRepository tpaManagementRepository;

	@Override
	public TpaManagement addTpaManagement(TpaManagement tpaManagement) {
		Date d=new Date();
		tpaManagement.setUpdatedAt(d);
		tpaManagement.setCreatedAt(d);
 		return tpaManagementRepository.save(tpaManagement);
	}
	
	@Override
	public TpaManagement getTpaManagement(int id) throws RecordNotFoundException {
 		 return tpaManagementRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("no TpaManagement records for this id"));
	}

	@Override
	public List<TpaManagement> getAllTpaManagement() throws RecordNotFoundException {
 		return tpaManagementRepository.findAll();
	}

	@Override
	public Object deleteTpaManagement(int id) {
		Map<String, Object> map=new HashMap<>();
		tpaManagementRepository.deleteById(id);
		map.put("status", 1);
 		return map;
	}
	
}
