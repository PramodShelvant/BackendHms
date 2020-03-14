package com.hms.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.BankAccountDetails;
import com.hms.management.serviceimpl.BankAccountDetailsServiceImpl;


@CrossOrigin()
@RestController
@RequestMapping("bankaccountdetails")
public class BankAccountDetailsController {

	
	@Autowired
	public BankAccountDetailsServiceImpl BankAccountDetails;
	
	
	@CrossOrigin
	@RequestMapping(value = "/",method = RequestMethod.POST,produces = "applcation/json")
 	public BankAccountDetails addBankAccountDetails(@RequestBody BankAccountDetails bankAccountDetails) {
		return BankAccountDetails.addBankAccountDetails(bankAccountDetails);
		
	}
	@CrossOrigin
	@RequestMapping(value = "{id}",method = RequestMethod.GET,produces = "application/json")
	public BankAccountDetails getBankAccountDetails(@PathVariable int id) throws RecordNotFoundException {
		return BankAccountDetails.getBankAccountDetails(id);
		
	}
}
