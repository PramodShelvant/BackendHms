package com.hms.management.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.AmbulanceCall;
import com.hms.management.repository.AmbulanceCallRepository;
import com.hms.management.service.AmbulanceCallService;

@Service
public class AmbulanceCallServiceImpl implements AmbulanceCallService{

	
	
	@Autowired
	public AmbulanceCallRepository ambulanceCallRepository;
	@Override
	public AmbulanceCall addAmbulanceCall(AmbulanceCall ambulanceCall) {
		Date d=new Date();
 		ambulanceCall.setUpdatedAt(d);
 		ambulanceCall.setCreatedAt(d);
 		return ambulanceCallRepository.save(ambulanceCall);
	}
	public AmbulanceCall getAmbulanceCall(int id) throws RecordNotFoundException {
 		return ambulanceCallRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("No ambulance record exist for given id"));
	}
	@Override
	public List<AmbulanceCall> getAllAmbulanve() throws RecordNotFoundException {
 		return ambulanceCallRepository.findAll();
	}
	 
	 
}
