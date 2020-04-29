package com.hms.management.service;

import java.util.List;

import com.hms.management.model.IncomeHead;

public interface IncomeHeadService {

	
	public IncomeHead addIncomeHead(IncomeHead incomeHead);
	public List<IncomeHead>  getAllIncomeHead();
	public Object updateIncomeHead(IncomeHead incomeHead);
	public Object deleteIncomeHead(int id);
}
