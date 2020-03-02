package com.hms.management.service;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.FinanceIncome;

public interface FinanceIncomeService {

 	public FinanceIncome getFinanceIncome(int id) throws RecordNotFoundException;
    public FinanceIncome addfinanace(FinanceIncome financeIncome) throws RecordNotFoundException;
	Object deleteFinanceIncome(int id);
 

}
