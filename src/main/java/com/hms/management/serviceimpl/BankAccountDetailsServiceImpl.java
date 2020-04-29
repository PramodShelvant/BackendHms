package com.hms.management.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.BankAccountDetails;
import com.hms.management.repository.BankAccountDetailsRepository;
import com.hms.management.service.BankAccountDetailsService;

@Service
public class BankAccountDetailsServiceImpl implements BankAccountDetailsService{

	
	
	
	@Autowired
	public BankAccountDetailsRepository bankAccountDetailsRepository;
	@Override
	public BankAccountDetails getBankAccountDetails(int id) throws RecordNotFoundException {
		 return bankAccountDetailsRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("No appointment record exist for given id"));
	}
	
	@Override
	public BankAccountDetails addBankAccountDetails(BankAccountDetails bankAccountDetails) {
 		return bankAccountDetailsRepository.save(bankAccountDetails);
	}

}
