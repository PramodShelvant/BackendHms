package com.hms.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.model.PathologyCategory;
import com.hms.management.repository.PathologyCategoryRepo;

@RestController
@CrossOrigin
@RequestMapping("/pathologyCategory")
public class PathologyCategoryController {
	@Autowired
	private PathologyCategoryRepo pathologyCategoryRepo;
	
	@PostMapping("/add")
	public <T> T add(@RequestBody PathologyCategory b) {
		return (T) pathologyCategoryRepo.save(b);
		
	}
	
	@GetMapping("/get")
	public <T> T get() {
		return (T) pathologyCategoryRepo.findAll();
		
	}
	
	@GetMapping("/delete/{id}")
	public <T> T delete(@PathVariable int id) {
		pathologyCategoryRepo.deleteById(id);
		return (T) (""+id);
		
	}


}
