package com.hms.management.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.model.BloodDonorCycle;
import com.hms.management.serviceimpl.BloodDonorCycleServiceImpl;
@CrossOrigin
@RestController
@RequestMapping("blooddonorcycle")
public class BloodDonorCycleController {

	
	@Autowired
	public BloodDonorCycleServiceImpl bloodDonorCycleServiceImpl;
	
	@CrossOrigin
	@RequestMapping(value = "",method = RequestMethod.POST,produces = "application/json")
	public BloodDonorCycle addBloodDonorCycle(@RequestBody BloodDonorCycle bloodDonorCycle) {
		return bloodDonorCycleServiceImpl.addBloodDonor(bloodDonorCycle);
		}
	
	@CrossOrigin
	@RequestMapping(value = "",method = RequestMethod.GET,produces = "application/json")
	public Iterable<BloodDonorCycle> getAllBloodDonorCycle(){
		return bloodDonorCycleServiceImpl.getAll();
		}
	
	@CrossOrigin
	@RequestMapping(value = "/{id}",method = RequestMethod.GET,produces = "application/json")
	public Optional<BloodDonorCycle> getByBloodDonorCycle(@PathVariable int id){
		return bloodDonorCycleServiceImpl.getByBloodDonorCycle(id);
	}
	
	
	@CrossOrigin
	@RequestMapping(value = "",method = RequestMethod.DELETE,produces = "application/json")
	public String deleteBloodDonorCycle(@PathVariable int id) {
		return bloodDonorCycleServiceImpl.deleteBloodDonorCycle(id);
		
	}
}
