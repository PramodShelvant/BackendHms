package com.hms.management.serviceimpl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.FinanceIncome;
import com.hms.management.repository.FinanceIncomeRepository;
import com.hms.management.service.FinanceIncomeService;

@Service
public class FinanceIncomeServiceImpl implements FinanceIncomeService{

	
	@Autowired
	public FinanceIncomeRepository financeIncomeRepository;

	 

	@Override
	public FinanceIncome addfinanace(FinanceIncome financeIncome) throws RecordNotFoundException {
 				Date d=new Date();
				financeIncome.setCreatedAt(d);
				financeIncome.setUpdatedAt(d);
	            return financeIncomeRepository.save(financeIncome);
          
 	    
	}
	@Override
	public FinanceIncome getFinanceIncome(int id) throws RecordNotFoundException {
  		Optional<FinanceIncome> financeIncome=financeIncomeRepository.findById(id);
		if(financeIncome.isPresent()) {           
			return financeIncome.get();
        } else {
            throw new RecordNotFoundException("No FinanceIncome record exist for given id");
        }
	}
	public List<FinanceIncome> getAllFinanceIncome() {
 		return financeIncomeRepository.findAll();
	}
	
	@Override
	public Object deleteFinanceIncome(int id) {
		Map<String, Object> map=new HashMap<>();
		financeIncomeRepository.deleteById(id);
		map.put("status", 1);
 		return map;
	}
	
	@Override
	public FinanceIncome adfinanceIncome(FinanceIncome financeIncome) {
 		return financeIncomeRepository.save(financeIncome);
	}
	 
}
