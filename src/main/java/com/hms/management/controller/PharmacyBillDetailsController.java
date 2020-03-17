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
import com.hms.management.model.PharmacyBillDetail;
import com.hms.management.repository.PharmacyBillDetailRepo;

@CrossOrigin
@RestController
@RequestMapping("pharmacyBillDetails")
public class PharmacyBillDetailsController {
	@Autowired
	PharmacyBillDetailRepo PharmacyBillDetailsRepo;
	
	@PostMapping("/add")
	public <T> T save(PharmacyBillDetail t) {
		Map<String,Object> map= new HashMap<>();
		PharmacyBillDetail c= PharmacyBillDetailsRepo.save(t);
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
				return (T) PharmacyBillDetailsRepo.findAll();
			}
		
			@PostMapping("/delete/{id}")
			public <T> T deleteById(@PathVariable int id) {
				Map<String,Object> map= new HashMap<>();
			 PharmacyBillDetailsRepo.deleteById(id);;
					map.put("msg", "successfully deleted");
					map.put("status","1");
					return (T) map;
			}	
				


}
