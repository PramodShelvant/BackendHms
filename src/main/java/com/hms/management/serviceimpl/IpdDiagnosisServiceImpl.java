package com.hms.management.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.IpdDiagnosis;
import com.hms.management.repository.IpdDiagnosisRepository;
import com.hms.management.service.IpdDiagnosisService;

@Service
public class IpdDiagnosisServiceImpl implements IpdDiagnosisService{

	
	@Autowired
	public IpdDiagnosisRepository ipdDiagnosisServiceRepository;

	@Override
	public IpdDiagnosis addIpdDiagnosis(IpdDiagnosis ipdDiagnosis) {
 		return ipdDiagnosisServiceRepository.save(ipdDiagnosis);
	}

	@Override
	public IpdDiagnosis getIpdDiagnosis(int id) throws RecordNotFoundException {
 		return ipdDiagnosisServiceRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("No birthrecord record exist for given id"));
	}

	
	@Override
	public IpdDiagnosis adIpdDiagnosis(IpdDiagnosis ipdDiagnosis) {
 		return ipdDiagnosisServiceRepository.save(ipdDiagnosis);
	}
}
