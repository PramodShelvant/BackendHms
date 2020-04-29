package com.hms.management.service;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.BankAccountDetails;

public interface BankAccountDetailsService {

	
	public BankAccountDetails getBankAccountDetails(int id) throws RecordNotFoundException;
    public BankAccountDetails addBankAccountDetails(BankAccountDetails bankAccountDetails);
}
