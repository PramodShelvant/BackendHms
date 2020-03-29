package com.hms.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.model.Organisation;
import com.hms.management.repository.OrganisationRepo;

@RestController
@CrossOrigin
@RequestMapping("/organisation")
public class OrganisationTpaController {
	@Autowired
	private OrganisationRepo organisationRepo;
	
	@PostMapping("/add")
	public <T> T add(@RequestBody Organisation b) {
		return (T) organisationRepo.save(b);
		
	}
	
	@GetMapping("/get")
	public <T> T get() {
		return (T) organisationRepo.findAll();
		
	}
	
	@GetMapping("/delete/{id}")
	public <T> T delete(@PathVariable int id) {
		organisationRepo.deleteById(id);
		return (T) (""+id);
		
	}
	
	
	


}
