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
import com.hms.management.model.PharmacyBillBasic;
import com.hms.management.repository.PharmacyBillBasicRepo;

@CrossOrigin
@RestController
@RequestMapping("pharmacyBillbasic")
public class PharmacyBillBasicController {
	@Autowired
	PharmacyBillBasicRepo PharmacyBillBasicRepo;
	
	@PostMapping("/add")
	public <T> T save(PharmacyBillBasic t) {
		Map<String,Object> map= new HashMap<>();
		PharmacyBillBasic c= PharmacyBillBasicRepo.save(t);
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
				return (T) PharmacyBillBasicRepo.findAll();
			}
		
			@PostMapping("/delete/{id}")
			public <T> T deleteById(@PathVariable int id) {
				Map<String,Object> map= new HashMap<>();
			 PharmacyBillBasicRepo.deleteById(id);;
					map.put("msg", "successfully deleted");
					map.put("status","1");
					return (T) map;
			}	
				


}
