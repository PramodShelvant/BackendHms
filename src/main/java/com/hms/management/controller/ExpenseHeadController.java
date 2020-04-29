package com.hms.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.model.ExpenseHead;
import com.hms.management.serviceimpl.ExpenseHeadServiceImpl;


@CrossOrigin
@RestController
@RequestMapping("expensehead")
public class ExpenseHeadController {

	
	
	@Autowired
	public ExpenseHeadServiceImpl expenseHeadServiceImpl;
	
	
	@CrossOrigin
	@RequestMapping(value = "",method = RequestMethod.POST,produces = "application/json")
	public ExpenseHead addExpenseHead(@RequestBody ExpenseHead expenseHead) {
		return expenseHeadServiceImpl.addExpenseHead(expenseHead);
		
	}

	@CrossOrigin
	@RequestMapping(value = "",method = RequestMethod.GET,produces = "application/json")
	public List<ExpenseHead>  getAllExpenseHead(){
		return expenseHeadServiceImpl.getAllExpenseHead();
		
	}
	
	@CrossOrigin
	@RequestMapping(value = "",method = RequestMethod.PUT,produces = "application/json")
	public Object updateExpenseHead(@RequestBody ExpenseHead expenseHead) {
		return expenseHeadServiceImpl.update(expenseHead);
		
	}
	@CrossOrigin
	@RequestMapping(value = "",method = RequestMethod.DELETE,produces = "application/json")
	public Object deleteExpenseHead(@PathVariable int id) {
		return expenseHeadServiceImpl.deleteExpenseHead(id);
		
	}
	
}
