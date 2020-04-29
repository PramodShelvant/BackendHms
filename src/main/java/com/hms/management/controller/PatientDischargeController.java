package com.hms.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.serviceimpl.PatientDischargeServiceImpl;
@CrossOrigin
@RestController
@RequestMapping("patientdischarge")
public class PatientDischargeController {

	
	@Autowired
	public PatientDischargeServiceImpl patientDischargeServiceImpl;
	
	
	/*
	 * @CrossOrigin
	 * 
	 * @RequestMapping(value = "/",method = RequestMethod.POST,produces =
	 * "application/json") public PatientDischarge addPatientDischarge(@RequestBody
	 * PatientDischarge patientDischarge) { return
	 * patientDischargeServiceImpl.addPatientDischarge(patientDischarge);
	 * 
	 * }
	 */
	 
 	
}
