package com.hms.management.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.ConsultantRegister;
import com.hms.management.repository.ConsultantRegisterRepository;
import com.hms.management.service.ConsultantRegisterService;

@Service
public class ConsultantRegisterServiceImpl implements ConsultantRegisterService{

	
	@Autowired
	public ConsultantRegisterRepository consultantRegisterRepository;

	@Override
	public ConsultantRegister getConsultantRegister(int id) throws RecordNotFoundException {
		 return consultantRegisterRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("No ComplainType record exist for given id"));
	}
}
