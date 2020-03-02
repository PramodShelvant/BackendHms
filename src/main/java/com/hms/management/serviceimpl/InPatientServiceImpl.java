package com.hms.management.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.InPatient;
import com.hms.management.repository.InPatientRepository;
import com.hms.management.service.InPatientService;

@Service
public class InPatientServiceImpl implements InPatientService{

	
	@Autowired
	public InPatientRepository inPatientRepository;

	@Override
	public InPatient addInPatient(InPatient inPatient) throws RecordNotFoundException {
		//inPatient.setOpdId("OPDID-"+DateTimeFormatter.ofPattern("yyyyMMddhhmmss").format(LocalDateTime.now()));

 		return inPatientRepository.save(inPatient);
	}

	@Override
	public List<InPatient> getInPatient(String patientId)   {
	   return inPatientRepository.findByPatientId(patientId);
	}


	@Override
	public List<InPatient> getAllInPatient() throws RecordNotFoundException {
		 return inPatientRepository.findAll();
	}

	@Override
	public Object deleteInPatient(int id) {
		Map<String, Object> map=new HashMap<>();
		inPatientRepository.deleteById(id);
		map.put("status", 1);
 		return map;
	}
}
