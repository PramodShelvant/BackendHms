package com.hms.management.service;

import java.util.List;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.DeathRecord;

public interface DeathRecordService {
	
	public DeathRecord addDeathRecord(DeathRecord deathRecord);
	public List<DeathRecord> getAllDeathRecord();
	DeathRecord getComplainType(int id) throws RecordNotFoundException;
	Object deleteDeathRecord(int id);

}
