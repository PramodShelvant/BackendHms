package com.hms.management.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.DeathRecord;
import com.hms.management.repository.DeathRecordRepository;
import com.hms.management.service.DeathRecordService;

@Service
public class DeathRecordServiceImpl implements DeathRecordService{

	
	
	@Autowired
	public DeathRecordRepository deathRecordRepository;
	
	@Override
	public DeathRecord addDeathRecord(DeathRecord deathRecord) {
 		return deathRecordRepository.save(deathRecord);
	}
	
	@Override
	public DeathRecord getComplainType(int id) throws RecordNotFoundException {
	 return deathRecordRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("No deathRecord record exist for given id"));
	}


	public List<DeathRecord> getAllDeathRecord() {
 		return deathRecordRepository.findAll();
	}

	@Override
	public Object deleteDeathRecord(int id) {
		Map<String, Object> map=new HashMap<>();
		deathRecordRepository.deleteById(id);
		map.put("status", 1);
 		return map;
	}

}
