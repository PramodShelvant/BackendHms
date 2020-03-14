package com.hms.management.service;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.IpdDiagnosis;

public interface IpdDiagnosisService {

	public IpdDiagnosis addIpdDiagnosis(IpdDiagnosis ipdDiagnosis);
	public IpdDiagnosis getIpdDiagnosis(int id) throws RecordNotFoundException;
	public IpdDiagnosis adIpdDiagnosis(IpdDiagnosis ipdDiagnosis);
	
	
}
