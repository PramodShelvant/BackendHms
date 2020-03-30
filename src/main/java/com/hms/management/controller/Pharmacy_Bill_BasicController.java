package com.hms.management.controller;

import java.util.HashMap;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.model.Pharmacy_Bill_Basic;
import com.hms.management.repository.Pharmacy_Bill_BasicRepo;
@CrossOrigin("*")
@RestController
@RequestMapping("/pharmacyBillBasic")
public class Pharmacy_Bill_BasicController {
	
	@Autowired
	Pharmacy_Bill_BasicRepo Pharmacy_Bill_BasicRepo;
	
	@PostMapping("/add")
	public <T> T save(@RequestBody Pharmacy_Bill_Basic t) {
		Map<String,Object> map= new HashMap<>();
		Pharmacy_Bill_Basic c= Pharmacy_Bill_BasicRepo.save(t);
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
				return (T) Pharmacy_Bill_BasicRepo.findAll();
			}
		@GetMapping("/get1")
		public <T> T get1() {
				return (T) Pharmacy_Bill_BasicRepo.fetchBill("");
			}
			@PostMapping("/delete/{id}")
			public <T> T deleteById(@PathVariable int id) {
				Map<String,Object> map= new HashMap<>();
			 Pharmacy_Bill_BasicRepo.deleteById(id);;
					map.put("msg", "successfully deleted");
					map.put("status","1");
					return (T) map;
			}	
				
	}
	


