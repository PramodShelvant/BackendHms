package com.hms.management.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.BirthRecord;
import com.hms.management.repository.BirthRecordRepository;
import com.hms.management.service.BirthRecordService;
@Service

public class BirthRecordServiceImpl implements BirthRecordService{

	
	@Autowired
	public BirthRecordRepository birthRecordRepository;

	@Override
	public BirthRecord addBirthRecord(BirthRecord BirthRecord) throws RecordNotFoundException {
 		return birthRecordRepository.save(BirthRecord);
	}

	@Override
	public BirthRecord getBirthRecord(int id) throws RecordNotFoundException {
 		return birthRecordRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("No birthrecord record exist for given id"));
	}
	
	

	@Override
	public List<BirthRecord> getAllBirthRecord() throws RecordNotFoundException {
 		return birthRecordRepository.findAll();
	}

	@Override
	public Object deleteBirthRecord(int id) {
		Map<String, Object> map=new HashMap<>();
		birthRecordRepository.deleteById(id);
		map.put("status", 1);
 		return map;
	}

	
	@Override
	public BirthRecord adBirthRecord(BirthRecord birthRecord) {
 		return birthRecordRepository.save(birthRecord);
	}
}
