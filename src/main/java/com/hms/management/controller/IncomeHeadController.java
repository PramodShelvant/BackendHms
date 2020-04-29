package com.hms.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.model.IncomeHead;
import com.hms.management.serviceimpl.IncomeHeadServiceImpl;


@CrossOrigin
@RestController
@RequestMapping("incomehead")
public class IncomeHeadController {

	
	@Autowired
	public IncomeHeadServiceImpl incomeHeadServiceImpl;
	
	
	@CrossOrigin
	@RequestMapping(value = "",method = RequestMethod.POST,produces = "application/json")
	public IncomeHead addIncomeHead(@RequestBody IncomeHead incomeHead) {
		return incomeHeadServiceImpl.addIncomeHead(incomeHead);
		
	}
	
	@CrossOrigin
	@RequestMapping(value = "",method = RequestMethod.GET,produces = "application/json")
	public List<IncomeHead>  getAllIncomeHead(){
		return incomeHeadServiceImpl.getAllIncomeHead();
		
	}
	
	@CrossOrigin
	@RequestMapping(value = "update",method = RequestMethod.PUT,produces = "application/json")
	public Object updateIncomeHead(@RequestBody IncomeHead incomeHead) {
		return incomeHeadServiceImpl.updateIncomeHead(incomeHead);
		
	}
	
	@CrossOrigin
	@RequestMapping(value = " /{id}",method = RequestMethod.DELETE,produces = "application/json")
	public Object deleteIncomeHead(int id) {
		return incomeHeadServiceImpl.deleteIncomeHead(id);
		
	}
}
