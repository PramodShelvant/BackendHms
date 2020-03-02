package com.hms.management.serviceimpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.OpdOutPatient;
import com.hms.management.repository.OpdOutPatientRepository;
import com.hms.management.service.OpdOutPatientService;

@Service
public class OpdOutPatientServiceImpl implements OpdOutPatientService{

	
	@Autowired
	public OpdOutPatientRepository opdOutPatientRepository;

	@Override
	public OpdOutPatient addOutPatient(OpdOutPatient opdOutPatient) throws RecordNotFoundException{
		opdOutPatient.setOpdId("OPDID-"+DateTimeFormatter.ofPattern("yyyyMMddhhmmss").format(LocalDateTime.now()));
 		return opdOutPatientRepository.save(opdOutPatient);
	}
	@Override
	public OpdOutPatient getOpdOutPatientById(int id) throws RecordNotFoundException {
		return opdOutPatientRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("No opdOutPatient record exist for given id"));
		 	}

	@Override
	public List<OpdOutPatient> getAllOpdOutPatient() throws RecordNotFoundException {
		  return opdOutPatientRepository.findAll();
	}
	
	@Override
	public List<OpdOutPatient> getByPatientId(String patientId) {
 		return opdOutPatientRepository.findByPatientId(patientId);
	}
	
	@Override
	public Object deleteOpdOutPatient(int id) {
		Map<String, Object> map=new HashMap<>();
		opdOutPatientRepository.deleteById(id);
		map.put("status", 1);
 		return map;
	}
}
