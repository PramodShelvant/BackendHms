package com.hms.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.model.ComplaintType;
import com.hms.management.repository.ComplaintTypeRepo;

@RestController
@CrossOrigin
@RequestMapping("/complaintType")
public class ComplaintTypeController {
	@Autowired
	private ComplaintTypeRepo complaintTypeRepo;
	
	@PostMapping("/add")
	public <T> T add(@RequestBody ComplaintType b) {
		return (T) complaintTypeRepo.save(b);
		
	}
	
	@GetMapping("/get")
	public <T> T get() {
		return (T) complaintTypeRepo.findAll();
		
	}
	
	@GetMapping("/delete/{id}")
	public <T> T delete(@PathVariable int id) {
		complaintTypeRepo.deleteById(id);
		return (T) (""+id);
		
	}
}
