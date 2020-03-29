package com.hms.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.model.Designation;
import com.hms.management.repository.DesignationRepo;

@RestController
@CrossOrigin
@RequestMapping("/designation")
public class DesignationController {
	@Autowired
	private DesignationRepo designationRepo;
	
	@PostMapping("/add")
	public <T> T add(@RequestBody Designation b) {
		return (T) designationRepo.save(b);
		
	}
	
	@GetMapping("/get")
	public <T> T get() {
		return (T) designationRepo.findAll();
		
	}
	
	@GetMapping("/delete/{id}")
	public <T> T delete(@PathVariable int id) {
		designationRepo.deleteById(id);
		return (T) (""+id);
		
	}

}
