package com.hms.management.service;

import java.util.List;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.FinanceExpenses;

public interface FinanceExpensesService {
	
	public FinanceExpenses addFinanceExpenses(FinanceExpenses financeExpenses);
	public FinanceExpenses getFinanceExpenses(int id) throws RecordNotFoundException;
    public List<FinanceExpenses> getAllFinanceExpenses() throws RecordNotFoundException;
	public Object deleteFinanceExpenses(int id);
	public FinanceExpenses adFinanceExpenses(FinanceExpenses financeExpence);
 

}
