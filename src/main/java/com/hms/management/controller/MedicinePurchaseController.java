package com.hms.management.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hms.management.beans.PurchaseMedicine;
import com.hms.management.model.MedicineBatchDetails;
import com.hms.management.model.PurchaseMedicineModal;
import com.hms.management.repository.PurchaseMedicineModalRepo;
import com.hms.management.serviceimpl.UploadFile;


@CrossOrigin
@RestController
@RequestMapping("/purchaseMedicine")
public class MedicinePurchaseController {
	
	@Autowired
	PurchaseMedicineModalRepo purchaseMedicineModalRepo;
	
	@Autowired
	UploadFile uploadfile;
	
	@PostMapping("/add")
	public <T> T save(@RequestBody PurchaseMedicineModal t) {
		Map<String,Object> map= new HashMap<>();
		PurchaseMedicineModal c= purchaseMedicineModalRepo.save(t);
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
	public <T> T saveFile(PurchaseMedicine t) throws JsonMappingException, JsonProcessingException {
		Map<String,Object> map= new HashMap<>();
		ObjectMapper mapper=new ObjectMapper();
		List<MedicineBatchDetails> li=mapper.readValue(t.getMedicine(), new TypeReference<List<MedicineBatchDetails>>(){});
		System.out.println(t);
		System.out.println(li);
		PurchaseMedicineModal c=new PurchaseMedicineModal();
		c.setId(t.getId());
		c.setAttachDocument(uploadfile.upload(t.getAttachDocument()));
		c.setDate(t.getDate());
		c.setDiscount(t.getDiscount());
		c.setMedicine(li);
		c.setNetamount(t.getNetamount());
		c.setNote(t.getNote());
		c.setSupplierId(t.getSupplierId());
		c.setTax(t.getTax());
		c.setTotal(t.getTotal());
		c= purchaseMedicineModalRepo.save(c);
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
				return (T) purchaseMedicineModalRepo.fetchAll();
			}
		
		
		
		
			@PostMapping("/delete/{id}")
			public <T> T deleteById(@PathVariable int id) {
				Map<String,Object> map= new HashMap<>();
			 purchaseMedicineModalRepo.deleteById(id);;
					map.put("msg", "successfully deleted");
					map.put("status","1");
					return (T) map;
			}	
				


}
