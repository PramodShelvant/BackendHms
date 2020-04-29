package com.hms.management.serviceimpl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.model.ExpenseHead;
import com.hms.management.repository.ExpenseHeadRepository;
import com.hms.management.service.ExpenseHeadService;

@Service
public class ExpenseHeadServiceImpl implements ExpenseHeadService {

	
	
	@Autowired
	public ExpenseHeadRepository expenseHeadRepository;
	
	
	@Override
	public ExpenseHead addExpenseHead(ExpenseHead expenseHead) {
 		return expenseHeadRepository.save(expenseHead);
	}

	@Override
	public List<ExpenseHead> getAllExpenseHead() {
 		return expenseHeadRepository.findAll();
	}

	@Override
	public Object update(ExpenseHead expenseHead) {
		Map<String, Object> map=new HashMap<>();
		int id=expenseHead.getId();
		Optional<ExpenseHead> ex=expenseHeadRepository.findById(id);
		if(ex.isPresent()) {
			ExpenseHead ih=ex.get();
			if(ih.getCreatedAt()!=null) {
			Date d=new Date();
			ih.setCreatedAt(d);}
			if(ih.getUpdatedAt()!=null){
			Date d=new Date();
			ih.setUpdatedAt(d);}
			if(ih.getDescription()!=null) {
			ih.setDescription(expenseHead.getDescription());}
			if(ih.getExpCategory()!=null) {
				ih.setExpCategory(expenseHead.getExpCategory());}
			if(ih.getIsActive()!=null) {
				ih.setIsActive(expenseHead.getIsActive());}
			map.put("updated data", expenseHeadRepository.save(expenseHead));
		}else {
			map.put("updated data", "update not succesfull");
			}
		return map;
	}

	@Override
	public Object deleteExpenseHead(int id) {
		
		Map<String, Object> map=new HashMap<>();
		Optional<ExpenseHead> ex=expenseHeadRepository.findById(id);
		if(ex.isPresent()) {
			expenseHeadRepository.deleteById(id);
			map.put("msg", "deleted succesful");
		}else {
			map.put("msg", "records not found on this id");

		}

 		return map;
	}

}
