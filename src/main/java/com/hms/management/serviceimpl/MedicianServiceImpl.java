package com.hms.management.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.Medician;
import com.hms.management.repository.MedicianRepository;
import com.hms.management.service.MedicianService;

@Service
public class MedicianServiceImpl implements MedicianService{
	
	@Autowired
	public MedicianRepository medicianRepository;
	
	@Override
	public Map<String, Object> addMedician(Medician medician) throws RecordNotFoundException {
		Map<String, Object> map=new HashMap<String,Object>();
	    map.put("medician details", medicianRepository.save(medician));
        return map;
 	    
	}
	@Override
	public Medician getMedician(int id) throws RecordNotFoundException {
 		return medicianRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("No Medician record exist for given id"));
	}

	@Override
	public List<Medician> getAllMedician() throws RecordNotFoundException {
 		return medicianRepository.findAll();
	}
	@Override
	public Object deleteMedician(int id) {
		Map<String, Object> map=new HashMap<>();
		medicianRepository.deleteById(id);
 		return map;
	}
	
	@Override
	public Medician adMedician(Medician medician) {
 		return medicianRepository.save(medician);
	}
}
