package com.hms.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.model.PharmacyBillBasic;
import com.hms.management.serviceimpl.PharmacyBillBasicServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("pharmacybillbasic")
public class PharmacyBillBasicController {

	
	
	@Autowired
	public PharmacyBillBasicServiceImpl  pharmacyBillBasicServiceImpl;
	
	
	@CrossOrigin
	@RequestMapping(value = "/",method = RequestMethod.POST,produces = "application/json")
	public PharmacyBillBasic addPharmacyBillBasic(@RequestBody PharmacyBillBasic pharmacyBillBasic) {
		return pharmacyBillBasicServiceImpl.addPharmacyBillBasic(pharmacyBillBasic);
		
	}
	
	@CrossOrigin
	@RequestMapping(value = "",method = RequestMethod.GET,produces = "application/json")
	public List<PharmacyBillBasic> getAllPharmacyBillBasic(){
		return pharmacyBillBasicServiceImpl.getAllPharmacyBillBasic();
    }
	
	
	@CrossOrigin
	@RequestMapping(value = "/{patientId}",method = RequestMethod.GET,produces = "application/json")
	public Object getByPatientId(@PathVariable String patientId) {
		return pharmacyBillBasicServiceImpl.getByPatientId(patientId);
		
	}
}
