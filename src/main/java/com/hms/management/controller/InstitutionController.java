package com.hms.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.model.Institution;
import com.hms.management.serviceimpl.InstitutionServiceImpl;

@RestController
@RequestMapping("institution/")
public class InstitutionController {

	
	
	@Autowired
	public InstitutionServiceImpl institutionServiceImpl; 
	
	
	@RequestMapping(value = "",method = RequestMethod.POST,produces = "application/json")
	public Institution addInstitution(@RequestBody Institution institution) {
		return institutionServiceImpl.addInstitution(institution);
		
	}
}
