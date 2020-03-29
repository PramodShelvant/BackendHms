package com.hms.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.model.LeaveType;
import com.hms.management.repository.LeaveTypeRepo;

@RestController
@CrossOrigin
@RequestMapping("/leaveType")
public class LeaveTypeController {
	@Autowired
	private LeaveTypeRepo leaveTypeRepo;
	
	@PostMapping("/add")
	public <T> T add(@RequestBody LeaveType b) {
		return (T) leaveTypeRepo.save(b);
		
	}
	
	@GetMapping("/get")
	public <T> T get() {
		return (T) leaveTypeRepo.findAll();
		
	}
	
	@GetMapping("/delete/{id}")
	public <T> T delete(@PathVariable int id) {
		leaveTypeRepo.deleteById(id);
		return (T) (""+id);
		
	}

}
