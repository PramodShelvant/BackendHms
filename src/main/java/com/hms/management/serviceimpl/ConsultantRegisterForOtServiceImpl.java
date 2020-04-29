package com.hms.management.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.model.ConsultantRegisterForOt;
import com.hms.management.repository.ConsultantRegisterForOtRepository;
import com.hms.management.service.ConsultantRegisterForOtService;

@Service
public class ConsultantRegisterForOtServiceImpl implements ConsultantRegisterForOtService{

	
	@Autowired
	public ConsultantRegisterForOtRepository consultantRegisterForOtRepository;

	public ConsultantRegisterForOt addConsultantRegisterForOt(ConsultantRegisterForOt consultantRegisterForOt) {
 		return consultantRegisterForOtRepository.save(consultantRegisterForOt);
	}

	@Override
	public List<ConsultantRegisterForOt> getConsultantRegisterForOt(String patientId) {
 		return consultantRegisterForOtRepository.findByPatientId(patientId);
	}

}
