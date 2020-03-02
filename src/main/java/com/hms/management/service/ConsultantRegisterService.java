package com.hms.management.service;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.ConsultantRegister;

public interface ConsultantRegisterService {

	
	public ConsultantRegister getConsultantRegister(int id) throws RecordNotFoundException;
}
