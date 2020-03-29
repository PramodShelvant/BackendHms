package com.hms.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.model.Floor;
import com.hms.management.repository.FloorRepo;

@RestController
@RequestMapping("/floor")
@CrossOrigin
public class FloorController {
	@Autowired
	FloorRepo floorRepo;
	
	@PostMapping("/add")
	public <T> T add(@RequestBody Floor floor) {
		
		return (T) floorRepo.save(floor);
	}
	@GetMapping("/get")
	public <T> T get() {
		
		return (T) floorRepo.findAll();
	}
	@CrossOrigin
	@PostMapping("/delete/{id}")
	public <T> T delete(@PathVariable int id) {
		floorRepo.deleteById(id);
		return (T) (""+id);
	}
	
	
	
}
