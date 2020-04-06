package com.hms.management.ambulance.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.ambulance.Repo.AmbulanceRepo;
import com.hms.management.ambulance.model.Ambulance;
@RestController
@CrossOrigin
@RequestMapping("/vehicle")
public class AmbulanceController {
	@Autowired
	private AmbulanceRepo ambulanceRepo;
	
	@PostMapping("/add")
	public <T> T add(@RequestBody Ambulance b) {
		return (T) ambulanceRepo.save(b);
		
	}
	
	@GetMapping("/get")
	public <T> T get() {
		return (T) ambulanceRepo.findAll();
		
	}
	
	@GetMapping("/delete/{id}")
	public <T> T delete(@PathVariable int id) {
		ambulanceRepo.deleteById(id);
		return (T) (""+id);
	
}
	}
