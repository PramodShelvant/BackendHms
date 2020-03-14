package com.hms.management.service;

import java.util.List;

import com.hms.management.model.ConsultantRegister;

public interface ConsultantRegisterService {

	
 
	public ConsultantRegister addConsultantRegister(ConsultantRegister consultantRegister);

	public  List<ConsultantRegister> getConsultantRegister(String ipdId);

 }
