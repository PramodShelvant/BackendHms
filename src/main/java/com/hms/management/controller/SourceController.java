package com.hms.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.model.Source;
import com.hms.management.repository.SourceRepo;

@RestController
@CrossOrigin
@RequestMapping("/source")
public class SourceController {
	@Autowired
	private SourceRepo sourceRepo;
	
	@PostMapping("/add")
	public <T> T add(@RequestBody Source b) {
		return (T) sourceRepo.save(b);
		
	}
	
	@GetMapping("/get")
	public <T> T get() {
		return (T) sourceRepo.findAll();
		
	}
	
	@GetMapping("/delete/{id}")
	public <T> T delete(@PathVariable int id) {
		sourceRepo.deleteById(id);
		return (T) (""+id);
		
	}
}
