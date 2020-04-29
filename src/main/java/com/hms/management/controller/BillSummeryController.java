package com.hms.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.model.BillSummery;
import com.hms.management.serviceimpl.BillSummeryServiceImpl;
@CrossOrigin
@RestController
@RequestMapping("billsummery")
public class BillSummeryController {

	@Autowired
	public BillSummeryServiceImpl billSummeryServiceImpl;
	
	@CrossOrigin
	@RequestMapping(value = "/",method = RequestMethod.POST,produces = "application/json")
	public BillSummery addBillSummery(@RequestBody BillSummery billSummery) {
		return billSummeryServiceImpl.addBillSummery(billSummery);
		
	}
	
	@RequestMapping(value ="/{opdId}",method = RequestMethod.GET,produces = "application/json")
	public List<BillSummery> getBillSummery(@PathVariable String opdId){
		return billSummeryServiceImpl.getBillSummery(opdId);
		
	}
}
