package com.hms.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.model.Setting_Charges;
import com.hms.management.repository.OrganisationChargesRepo;
@RestController
@CrossOrigin
@RequestMapping("/organisationCharges")
public class OrganisationChargeController {
	@Autowired
	private OrganisationChargesRepo organisationChargesRepo;
	
	@PostMapping("/add")
	public <T> T add(@RequestBody Setting_Charges b) {
		return (T) organisationChargesRepo.save(b);
		
	}
	
	@GetMapping("/get")
	public <T> T get() {
		return (T) organisationChargesRepo.findAll();
		
	}
	
	@GetMapping("/delete/{id}")
	public <T> T delete(@PathVariable int id) {
		organisationChargesRepo.deleteById(id);
		return (T) (""+id);
		
	}
	

}
