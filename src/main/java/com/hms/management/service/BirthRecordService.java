package com.hms.management.service;

import java.util.List;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.BirthRecord;

public interface BirthRecordService {

	
	public BirthRecord addBirthRecord(BirthRecord BirthRecord) throws RecordNotFoundException;
    public BirthRecord getBirthRecord(int id) throws RecordNotFoundException;
    public List<BirthRecord> getAllBirthRecord() throws RecordNotFoundException;
	public Object deleteBirthRecord(int id);
    public BirthRecord adBirthRecord(BirthRecord birthRecord);

}
