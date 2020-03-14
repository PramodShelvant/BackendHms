package com.hms.management.serviceimpl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.FinanceExpenses;
import com.hms.management.repository.FinanceExpensesRepository;
import com.hms.management.service.FinanceExpensesService;

@Service
public class FinanceExpensesServiceImpl implements FinanceExpensesService{

	@Autowired
	public FinanceExpensesRepository financeExpensesRepository;

	public FinanceExpenses addFinanceExpenses(FinanceExpenses financeExpenses) {
		Date d=new Date();
		financeExpenses.setUpdatedAt(d);
		financeExpenses.setCreatedAt(d);
 		return financeExpensesRepository.save(financeExpenses);
	}

	@Override
	public FinanceExpenses getFinanceExpenses(int id) throws RecordNotFoundException {
 		return financeExpensesRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("no FinanceExpenses records for this id"));
	}

	@Override
	public List<FinanceExpenses> getAllFinanceExpenses() throws RecordNotFoundException {
 		return financeExpensesRepository.findAll();
	}

	@Override
	public Object deleteFinanceExpenses(int id) {
		Map<String, Object> map=new HashMap<>();
		financeExpensesRepository.deleteById(id);
		map.put("status", 1);
 		return map;
	}

	@Override
	public FinanceExpenses adFinanceExpenses(FinanceExpenses financeExpence) {
 		return financeExpensesRepository.save(financeExpence);
	}

	 
}
