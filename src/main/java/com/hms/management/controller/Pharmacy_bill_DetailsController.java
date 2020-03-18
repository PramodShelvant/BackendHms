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

import com.hms.management.model.Pharmacy_bill_Details;
import com.hms.management.repository.Pharmacy_bill_DetailsRepo;
import com.hms.management.serviceimpl.UploadFile;


@CrossOrigin
@RestController
@RequestMapping("purchaseBillDetais")
public class Pharmacy_bill_DetailsController {
	
	@Autowired
	Pharmacy_bill_DetailsRepo Pharmacy_bill_DetailsRepo;
	
	@Autowired
	UploadFile uploadfile;
	
	@PostMapping("/add")
	public <T> T save(@RequestBody Pharmacy_bill_Details t) {
		Map<String,Object> map= new HashMap<>();
		Pharmacy_bill_Details c= Pharmacy_bill_DetailsRepo.save(t);
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
				return (T) Pharmacy_bill_DetailsRepo.findAll();
			}
		
		
		
			@PostMapping("/delete/{id}")
			public <T> T deleteById(@PathVariable int id) {
				Map<String,Object> map= new HashMap<>();
			 Pharmacy_bill_DetailsRepo.deleteById(id);;
					map.put("msg", "successfully deleted");
					map.put("status","1");
					return (T) map;
			}	
				


}
