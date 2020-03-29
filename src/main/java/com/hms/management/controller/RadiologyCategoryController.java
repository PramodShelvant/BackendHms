package com.hms.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.model.RadiologyCategory;
import com.hms.management.repository.RadiologyCategoryRepo;

@RestController
@CrossOrigin
@RequestMapping("/radiologyCategory")
public class RadiologyCategoryController {
	@Autowired
	private RadiologyCategoryRepo radiologyCategoryRepo;
	
	@PostMapping("/add")
	public <T> T add(@RequestBody RadiologyCategory b) {
		return (T) radiologyCategoryRepo.save(b);
		
	}
	
	@GetMapping("/get")
	public <T> T get() {
		return (T) radiologyCategoryRepo.findAll();
		
	}
	
	@GetMapping("/delete/{id}")
	public <T> T delete(@PathVariable int id) {
		radiologyCategoryRepo.deleteById(id);
		return (T) (""+id);
		
	}


}
