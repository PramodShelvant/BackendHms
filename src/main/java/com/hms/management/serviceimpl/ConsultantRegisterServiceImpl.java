package com.hms.management.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.model.ConsultantRegister;
import com.hms.management.repository.ConsultantRegisterRepository;
import com.hms.management.service.ConsultantRegisterService;

@Service
public class ConsultantRegisterServiceImpl implements ConsultantRegisterService{

	
	@Autowired
	public ConsultantRegisterRepository consultantRegisterRepository;

	@Override
	public List<ConsultantRegister> getConsultantRegister(String ipdId) {
		  return consultantRegisterRepository.findByIpdId(ipdId);
	}

	@Override
	public ConsultantRegister addConsultantRegister(ConsultantRegister consultantRegister) {
		
 		return consultantRegisterRepository.save(consultantRegister);
	}
}
