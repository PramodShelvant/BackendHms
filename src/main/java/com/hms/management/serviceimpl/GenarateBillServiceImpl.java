package com.hms.management.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.GenarateBills;
import com.hms.management.repository.GenarateBillRepository;
import com.hms.management.service.GenarateBillService;
@Service
public class GenarateBillServiceImpl implements GenarateBillService{
	
	
	@Autowired
	public GenarateBillRepository genarateBillRepository;

	@Override
	public GenarateBills addGenarateBill(GenarateBills genarateBills) throws RecordNotFoundException {
		   return genarateBillRepository.save(genarateBills);
	}

	@Override
	public GenarateBills getGenarateBills(int id) throws RecordNotFoundException {
	 return genarateBillRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("No genarateBill record exist for given id"));
	}


	
	@Override
	public List<GenarateBills> getAll() throws RecordNotFoundException {
		return genarateBillRepository.findAll();
 			 
	}

	@Override
	public Object deleteGenarateBills(int id) {
		Map<String, Object> map=new HashMap<>();
		genarateBillRepository.deleteById(id);
		map.put("status", 1);
 		return map;
	}

}
