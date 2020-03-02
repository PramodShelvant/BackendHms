package com.hms.management.serviceimpl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.Rediology;
import com.hms.management.repository.RediologyRepository;
import com.hms.management.service.RediologyService;
@Service
public class RediologyServiceImpl implements RediologyService{
	
	@Autowired
	public RediologyRepository rediologyRepository;

	@Override
	public Rediology addRediology(Rediology rediology) throws RecordNotFoundException {
		Date d=new Date();
		rediology.setCreatedAt(d);
		rediology.setUpdatedAt(d);
 		return rediologyRepository.save(rediology);
	}
	@Override
	public Rediology getRediology(int id) throws RecordNotFoundException {
 		 return rediologyRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("no Rediology records for this id"));
	}

	@Override
	public List<Rediology> getAllRediology() throws RecordNotFoundException {
 		return rediologyRepository.findAll();
	}
	@Override
	public Object deleteRediology(int id) {
		
		Map<String, Object> map=new HashMap<String, Object>();
		rediologyRepository.deleteById(id);
		map.put("status", 1);
 		return map;
	}
	 
}
