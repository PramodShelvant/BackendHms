package com.hms.management.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.model.Payment;
import com.hms.management.repository.PaymentRepository;
import com.hms.management.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{

	
	@Autowired
	public PaymentRepository paymentRepository;

	@Override
	public Payment addPayment(Payment payment) {
 		return paymentRepository.save(payment);
	}

	@Override
	public List<Payment> getPayment(String opdId) {
		// TODO Auto-generated method stub
		return null;
	}
}
