package com.hms.management.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.PurchaseMedician;
import com.hms.management.repository.PurchaseMedicianRepository;
import com.hms.management.service.PurchaseMedicianService;

@Service
public class PurchaseMedicianServiceImpl implements PurchaseMedicianService{
	
	@Autowired
	public PurchaseMedicianRepository purchaseMedicianRepository;
	
	@Override
	public Map<String, Object> addPurchaseMedician(PurchaseMedician purchaseMedician) throws RecordNotFoundException{
		Map<String, Object> map=new HashMap<String, Object>();
	    map.put("PurchaseMedicians details", purchaseMedicianRepository.save(purchaseMedician));
	    return map;
	}

	@Override
	public PurchaseMedician getPurchaseMedician(int id) throws RecordNotFoundException {
 		return purchaseMedicianRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("no PurchaseMedician records for this id"));
	}

	@Override
	public List<PurchaseMedician> getAllPurchaseMedician() throws RecordNotFoundException {
 		return purchaseMedicianRepository.findAll();
	}
    
	@Override
	public Object deletePurchaseMedician(int id) {
		Map<String, Object> map=new HashMap<>();
		purchaseMedicianRepository.deleteById(id);
		map.put("status", 1);
 		return map;
	}

	
	@Override
	public PurchaseMedician adPurchaseMedician(PurchaseMedician purchaseMedician) {
 		return purchaseMedicianRepository.save(purchaseMedician);
	}
}
