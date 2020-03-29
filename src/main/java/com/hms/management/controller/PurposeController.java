package com.hms.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.model.Purpose;
import com.hms.management.repository.PurposeRepository;

@RestController
@CrossOrigin
@RequestMapping("/purpose")
public class PurposeController {
	@Autowired
	private PurposeRepository purposeRepository;
	
	@PostMapping("/add")
	public <T> T add(@RequestBody Purpose b) {
		return (T) purposeRepository.save(b);
		
	}
	
	@GetMapping("/get")
	public <T> T get() {
		return (T) purposeRepository.findAll();
		
	}
	
	@GetMapping("/delete/{id}")
	public <T> T delete(@PathVariable int id) {
		purposeRepository.deleteById(id);
		return (T) (""+id);
		
	}
	
	
	

}
