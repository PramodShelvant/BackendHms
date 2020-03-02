package com.hms.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.ConsultantRegister;
import com.hms.management.serviceimpl.ConsultantRegisterServiceImpl;

@RestController
public class ConsultantRegisterController {

	
	@Autowired
	public ConsultantRegisterServiceImpl consultantRegisterServiceImpl;
	
	
	
	@CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public ConsultantRegister getConsultantRegister(@PathVariable int id) throws RecordNotFoundException {
		return consultantRegisterServiceImpl.getConsultantRegister(id);
		
	}
}
