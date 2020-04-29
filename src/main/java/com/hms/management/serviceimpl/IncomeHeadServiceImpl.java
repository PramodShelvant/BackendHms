package com.hms.management.serviceimpl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.model.IncomeHead;
import com.hms.management.repository.IncomeHeadRepository;
import com.hms.management.service.IncomeHeadService;

@Service
public class IncomeHeadServiceImpl implements IncomeHeadService{

	@Autowired
	public IncomeHeadRepository incomeHeadRepository;

	@Override
	public IncomeHead addIncomeHead(IncomeHead incomeHead) {
		Date d=new Date();
		incomeHead.setCreatedAt(d);
		incomeHead.setUpdatedAt(d);
 		return incomeHeadRepository.save(incomeHead);
	}

	@Override
	public List<IncomeHead> getAllIncomeHead() {
 		return incomeHeadRepository.findAll();
	}
	
	@Override
	public Object updateIncomeHead(IncomeHead incomeHead) {
		
		Map<String, Object> map=new HashMap<>();
		int id=incomeHead.getId();
		Optional<IncomeHead> ic=incomeHeadRepository.findById(id);
		if(ic.isPresent()) {
			IncomeHead ih=ic.get();
			if(ih.getCreatedAt()!=null) {
			Date d=new Date();
			ih.setCreatedAt(d);}
			if(ih.getUpdatedAt()!=null){
			Date d=new Date();
			ih.setUpdatedAt(d);}
			if(ih.getDescription()!=null) {
			ih.setDescription(incomeHead.getDescription());}
			if(ih.getIncomeCategory()!=null) {
				ih.setIncomeCategory(incomeHead.getIncomeCategory());}
			if(ih.getIsActive()!=null) {
				ih.setIsActive(incomeHead.getIsActive());}
			map.put("updated data", incomeHeadRepository.save(incomeHead));
		}else {
			map.put("updated data", "update not succesfull");
			}
		return map;
		
	}

	@Override
	public Object deleteIncomeHead(int id) {
		Map<String, Object> map=new HashMap<>();
		Optional<IncomeHead> ex=incomeHeadRepository.findById(id);
		if(ex.isPresent()) {
			incomeHeadRepository.deleteById(id);
			map.put("msg", "deleted succesful");
		}else {
			map.put("msg", "records not found on this id");
			}
		return map;
		}
	}
