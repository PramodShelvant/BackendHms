package com.hms.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.model.Prescription;
import com.hms.management.serviceimpl.PrescriptionServiceImpl;
@CrossOrigin()
@RestController
@RequestMapping("prescription")
public class PrescriptionController {

	
	@Autowired
	public PrescriptionServiceImpl prescriptionServiceImpl;
	
	
	@CrossOrigin
	@RequestMapping(value ="/",method = RequestMethod.POST,produces = "application/json")
	public Prescription addPrescription(@RequestBody Prescription prescription) {
 		return prescriptionServiceImpl.addPrescription(prescription);
		
	}
	
	@CrossOrigin
	@RequestMapping(value ="/{opdId}",method = RequestMethod.GET,produces = "application/json")
	public List<Prescription> getPrescription(@PathVariable String opdId) {
           return prescriptionServiceImpl.getPrescription(opdId);
		
	}
	
}
