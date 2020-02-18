package com.hms.management.service;

import java.util.List;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.FinanceExpenses;

public interface FinanceExpensesService {
	
	public FinanceExpenses addFinanceExpenses(FinanceExpenses financeExpenses);
	FinanceExpenses getFinanceExpenses(int id) throws RecordNotFoundException;
    List<FinanceExpenses> getAllFinanceExpenses() throws RecordNotFoundException;


}
