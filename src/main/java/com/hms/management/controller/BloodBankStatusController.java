package com.hms.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.model.BloodBankStatus;
import com.hms.management.serviceimpl.BloodBankStatusServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("bloodbankstatus")
public class BloodBankStatusController {

	
	@Autowired
	public BloodBankStatusServiceImpl bloodBankStatusServiceImpl;
	
	
	
	@CrossOrigin
	@RequestMapping(value = "",method = RequestMethod.POST,produces = "application/json")
	public BloodBankStatus addBloodBankStatus(@RequestBody BloodBankStatus bloodBankStatus) {
		return bloodBankStatusServiceImpl.addBloodBankStatus(bloodBankStatus);
	}
	
	@CrossOrigin
	@RequestMapping(value = "",method = RequestMethod.GET,produces = "application/json")
	public List<BloodBankStatus> getBloodBankStatus(){
		return bloodBankStatusServiceImpl.getBloodBankStatus();
	}
	
	@CrossOrigin
	@RequestMapping(value = "{/bloodGroup}",method = RequestMethod.GET,produces = "application/json")
	public Object getByBloodBankStatus(@PathVariable String bloodGroup){
		return bloodBankStatusServiceImpl.getByBloodGroup(bloodGroup);
		
	}
}
