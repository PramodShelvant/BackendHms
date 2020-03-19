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

import com.hms.management.beans.PharmacyBean;
import com.hms.management.model.Pharmacy;
import com.hms.management.repository.PharmacyRepo;
import com.hms.management.serviceimpl.UploadFile;

@CrossOrigin
@RestController
@RequestMapping("pharmacy")
public class PharmacyController {
	@Autowired
	PharmacyRepo PharmacyRepo;
	
	@Autowired
	UploadFile uploadfile;
	
	@PostMapping("/add")
	public <T> T save(@RequestBody Pharmacy t) {
		Map<String,Object> map= new HashMap<>();
		Pharmacy c= PharmacyRepo.save(t);
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
	
	@PostMapping("/add/file")
	public <T> T saveFile(PharmacyBean t) {
		Map<String,Object> map= new HashMap<>();
		Pharmacy c=new Pharmacy();
		c.setId(t.getId());
		c.setMedicineCategoryId(t.getMedicineCategoryId());
		c.setMedicineCompany(t.getMedicineCompany());
		c.setMedicineComposition(t.getMedicineComposition());
		c.setMedicineGroup(t.getMedicineGroup());
		c.setMedicineImage(uploadfile.upload(t.getMedicineImage()));
		c.setMedicineName(t.getMedicineName());
		c.setMinLevel(t.getMinLevel());
		c.setNote(t.getNote());
		c.setReorderLevel(t.getReorderLevel());
		c.setSupplier(t.getSupplier());
		c.setUnit(t.getSupplier());
		c.setUnitPacking(t.getUnitPacking());
		c.setVat(t.getVat());
		c.setVatAc(t.getVatAc());
		//c.setCreatedAt(createdAt);
		c= PharmacyRepo.save(c);
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
				return (T) PharmacyRepo.fetchPharmacy();
			}
		
		@GetMapping("/getbycategoryId/{id}")
		public <T> T getbycategoryId(@PathVariable int id) {
				return (T) PharmacyRepo.findByMedicineCategory(id);
			}
		
		
			@PostMapping("/delete/{id}")
			public <T> T deleteById(@PathVariable int id) {
				Map<String,Object> map= new HashMap<>();
			 PharmacyRepo.deleteById(id);;
					map.put("msg", "successfully deleted");
					map.put("status","1");
					return (T) map;
			}	
				


}
