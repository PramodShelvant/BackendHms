package com.hms.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.model.Bed;
import com.hms.management.repository.BedRepo;
@RestController
@CrossOrigin
@RequestMapping("/bed")
public class BedController {
	@Autowired
	private BedRepo bedRepo;
	
	@PostMapping("/add")
	public <T> T add(@RequestBody Bed b) {
		return (T) bedRepo.save(b);
		
	}
	
	@GetMapping("/get")
	public <T> T get() {
		return (T) bedRepo.fetchAll();
		
	}
	
	@GetMapping("/delete/{id}")
	public <T> T delete(@PathVariable int id) {
		bedRepo.deleteById(id);
		return (T) (""+id);
	
}
	}
