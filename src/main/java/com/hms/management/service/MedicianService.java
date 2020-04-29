package com.hms.management.service;

import java.util.List;
import java.util.Map;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.Medician;

public interface MedicianService {

	public Map<String, Object> addMedician(Medician medician) throws RecordNotFoundException;

	public Medician getMedician(int id) throws RecordNotFoundException;

	public List<Medician> getAllMedician() throws RecordNotFoundException;

	public Object deleteMedician(int id);

	public Medician adMedician(Medician medician);

}
