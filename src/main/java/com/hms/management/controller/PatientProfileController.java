package com.hms.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.model.PatientProfile;
import com.hms.management.serviceimpl.PatientProfileServiceImpl;
@CrossOrigin()
@RestController
@RequestMapping("patientprofile")
public class PatientProfileController {

	
	@Autowired
	public PatientProfileServiceImpl patientProfileServiceImpl;
	
	
	
	@CrossOrigin
 	@RequestMapping(value = "/", method = RequestMethod.PUT, produces = "application/json")
	public PatientProfile addPatientProfile(@RequestBody PatientProfile patientProfile) {
		 return patientProfileServiceImpl.addPatientProfile(patientProfile);
		
	}
	@CrossOrigin
 	@RequestMapping(value = "/{patientId}", method = RequestMethod.GET, produces = "application/json")
    public PatientProfile getPatientProfile(@PathVariable String patientId){
		return patientProfileServiceImpl.getPatientProfile(patientId);
		
	}
}
