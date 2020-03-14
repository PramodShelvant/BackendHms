package com.hms.management.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.OpdDiagnosis;
import com.hms.management.repository.OpdDiagnosisRepository;
import com.hms.management.service.OpdDiagnosisService;

@Service
public class OpdDiagnosisServiceImpl implements OpdDiagnosisService{

	
	
	@Autowired
	public OpdDiagnosisRepository opdDiagnosisRepository;
	
	@Override
	public OpdDiagnosis addOpdDiagnosis(OpdDiagnosis opdDiagnosis) {
 		return opdDiagnosisRepository.save(opdDiagnosis);
	}

	@Override
	public Object getOpdDiagnosis(String opdId) throws RecordNotFoundException {
		
 		return opdDiagnosisRepository.findByOpdId(opdId);
	}

	@Override
	public OpdDiagnosis adOpdDiagnosis(OpdDiagnosis opdDiagnosis) {
 		return opdDiagnosisRepository.save(opdDiagnosis);
	}
	
	 
	
	 
}
