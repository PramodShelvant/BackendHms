package com.hms.management.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.model.MedicineBatchDetails;
import com.hms.management.repository.MedicineBatchDetailsRepo;
@CrossOrigin
@RestController
@RequestMapping("/medicineBatchDetails")
public class MedicineBatchDetailsController {
	@Autowired
	MedicineBatchDetailsRepo medicineBatchDetailsRepo;
	
	@PostMapping("/add")
	public <T> T save(MedicineBatchDetails t) {
		Map<String,Object> map= new HashMap<>();
			MedicineBatchDetails c= medicineBatchDetailsRepo.save(t);
		if(c.getId()==t.getId()) {
			map.put("msg", "successfully updated");
			map.put("status","1");
			map.put("data",c);
			return (T) map;
		}else {
			map.put("msg", "successfully saved");
			map.put("status","1");
			map.put("data",c);
			return (T) map;
		}
	}
		@GetMapping("/get")
		public <T> T get() {
				return (T) medicineBatchDetailsRepo.findAll();
			}
		@GetMapping("/getexpiry")
		public <T> T get1() {
				return (T) medicineBatchDetailsRepo.fetchAllExpiry();
			}
		
		@GetMapping("/getbypharmacyId/{id}")
		public <T> T get(@PathVariable int id) {
				return (T) medicineBatchDetailsRepo.fetchByPharmacyId(id);
			}
		@GetMapping("/fetchbypharmacyId/{id}")
		public <T> T fetch(@PathVariable int id) {
				return (T) medicineBatchDetailsRepo.findByPharmacyId(id);
			}
		@GetMapping("/getbybathnum/{id}")
		public <T> T getById(@PathVariable int id) {
			//medicineBatchDetailsRepo.findById(id);
				return (T) medicineBatchDetailsRepo.findById(id);
			}
			@PostMapping("/delete/{id}")
			public <T> T deleteById(@PathVariable int id) {
				Map<String,Object> map= new HashMap<>();
			 medicineBatchDetailsRepo.deleteById(id);;
					map.put("msg", "successfully deleted");
					map.put("status","1");
					return (T) map;
			}	
				
	}
	


