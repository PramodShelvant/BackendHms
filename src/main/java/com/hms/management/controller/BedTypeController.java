package com.hms.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.model.BedType;
import com.hms.management.repository.BedTypeRepo;
@RestController
@CrossOrigin
@RequestMapping("/bedType")
public class BedTypeController {
	@Autowired
	private BedTypeRepo bedTypeRepo;
	
	@PostMapping("/add")
	public <T> T add(@RequestBody BedType b) {
		return (T) bedTypeRepo.save(b);
		
	}
	
	@GetMapping("/get")
	public <T> T get() {
		return (T) bedTypeRepo.findAll();
		
	}
	
	@GetMapping("/delete/{id}")
	public <T> T delete(@PathVariable int id) {
		bedTypeRepo.deleteById(id);
		return (T) (""+id);
		
	}
	
	
	
	
}
