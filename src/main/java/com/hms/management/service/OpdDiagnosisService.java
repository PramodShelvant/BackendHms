package com.hms.management.service;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.OpdDiagnosis;

public interface OpdDiagnosisService {

	
	
	public OpdDiagnosis addOpdDiagnosis(OpdDiagnosis opdDiagnosis);
    public Object getOpdDiagnosis(String opdId) throws RecordNotFoundException;
    public OpdDiagnosis adOpdDiagnosis(OpdDiagnosis opdDiagnosis);

}
