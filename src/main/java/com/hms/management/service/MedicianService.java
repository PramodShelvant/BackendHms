package com.hms.management.service;

import java.util.List;
import java.util.Map;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.Medician;

public interface MedicianService {

	Map<String, Object> addMedician(Medician medician) throws RecordNotFoundException;

	Medician getMedician(int id) throws RecordNotFoundException;

	List<Medician> getAllMedician() throws RecordNotFoundException;

}
