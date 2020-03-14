package com.hms.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.model.Payment;
import com.hms.management.serviceimpl.PaymentServiceImpl;

@RestController
@RequestMapping("payment")
public class PaymentController {

	@Autowired
	public PaymentServiceImpl paymentServiceImpl;
	
	
	@RequestMapping(value = "/",method = RequestMethod.POST,produces = "application/json")
	public Payment addPayment(@RequestBody Payment payment) {
		return paymentServiceImpl.addPayment(payment);
		
	}
}
