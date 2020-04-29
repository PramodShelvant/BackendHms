package com.hms.management.service;

import java.util.List;

import com.hms.management.model.ExpenseHead;

public interface ExpenseHeadService {

	
	
	public ExpenseHead addExpenseHead(ExpenseHead expenseHead);
	public List<ExpenseHead> getAllExpenseHead();
	public Object update(ExpenseHead expenseHead);
	public Object deleteExpenseHead(int id);
	
}
